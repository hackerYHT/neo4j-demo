package com.tao.neo4jdemo.Service.business.impl;

import com.tao.neo4jdemo.Service.business.ApplicationService;
import com.tao.neo4jdemo.Service.business.InstanceService;
import com.tao.neo4jdemo.Service.business.RelationshipService;
import com.tao.neo4jdemo.Service.ditinng.DitingService;
import com.tao.neo4jdemo.entity.InvokeTreeNode;
import com.tao.neo4jdemo.entity.business.Application;
import com.tao.neo4jdemo.entity.business.Instance;
import com.tao.neo4jdemo.entity.business.relationship.Invoke;
import com.tao.neo4jdemo.repository.business.ApplicationRepository;
import com.tao.neo4jdemo.repository.business.InstanceRepository;
import com.tao.neo4jdemo.resp.Dditing.LinkData;
import com.tao.neo4jdemo.resp.Dditing.NodeData;
import com.tao.neo4jdemo.resp.Dditing.TraceContent;
import com.tao.neo4jdemo.resp.Dditing.TraceLinkResponse;
import com.tao.neo4jdemo.utils.TreeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yehaitao01
 */
@Service
@Slf4j
public class RelationshipServiceImpl implements RelationshipService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private InstanceService instanceService;

    @Autowired
    private InstanceRepository instanceRepository;

    @Autowired
    private DitingService ditingService;

    @Override
    public void createRelationship4AppInstance(Long appId, String instanceName) {
        applicationRepository.createRelationship4AppInstance(appId, instanceName);
    }

    @Override
    public void createAllAppInstanceRelationship() {
        List<Instance> instanceList = instanceService.getAllInstance();
        instanceList.forEach(instance -> {
            String appName = instance.getAppName();
            if (appName == null || appName.isEmpty()) {
                return;
            }
            Application application = applicationService.findByName(appName);
            if (application != null) {
                createRelationship4AppInstance(application.getAppId(), instance.getName());
            }
        });
    }

    @Override
    public void createInvokeRelationShip() {
        List<Application> applicationList = applicationService.getAllApplication();
        applicationList = applicationList.stream().filter(e -> !"offline".equals(e.getStatus())).collect(Collectors.toList());
        int batchSize = 100;
        List<List<Application>> batchedApplicationsList = new ArrayList<>();
        for (int i = 0; i < applicationList.size(); i += batchSize) {
            int endIndex = Math.min(i + batchSize, applicationList.size());
            List<Application> batchedApplications = applicationList.subList(i, endIndex);
            batchedApplicationsList.add(batchedApplications);
        }
        for (int i = 2; i < batchedApplicationsList.size(); i++) {
            int count = 0;
            for (Application application : batchedApplicationsList.get(i)) {
                //TODO 会不会调挂掉？
                try {
                    count++;
                    log.info("当前执行应用{}-{}：{}", i, count, application.getDomain());
                    List<TraceContent> traceContentList = ditingService.getTraces(application.getDomain());
                    Map<String, List<String>> traceIdMap = traceContentList.stream()
                            .collect(Collectors.groupingBy(TraceContent::getServiceName,
                                    Collectors.mapping(TraceContent::getTraceId, Collectors.toList())));
                    log.info("该应用serverName：{}", traceIdMap.entrySet());
                    traceIdMap.forEach((serverName, traceIdList) -> {
                        try {
                            log.info("当前执行traceId:{}", traceIdList.get(0));
                            if (CollectionUtils.isEmpty(traceIdList)) {
                                return;
                            }
                            TraceLinkResponse traceLinkResponse = ditingService.getTraceDetailByTraceId(traceIdList.get(0));
                            Map<String, Application> appMap = new HashMap<>();
                            InvokeTreeNode root = analyzeTraceDetail(traceLinkResponse, appMap);
                            if (Objects.isNull(root)) {
                                return;
                            }
                            createInvoke(root, appMap);
                        } catch (StackOverflowError e) {
                            log.error("Caught StackOverflowError: " + e.getMessage());
                        } catch (Exception e) {
                            log.error("报错信息：", e);
                        }
                    });
                } catch (Exception e) {
                    log.error("报错信息：", e);
                    log.info("Application Group - {}", i);
                }
            }
        }
    }

    @Override
    public void tmp(String traceId) {
        try {
            TraceLinkResponse traceLinkResponse = ditingService.getTraceDetailByTraceId(traceId);
            Map<String, Application> appMap = new HashMap<>();
            InvokeTreeNode root = analyzeTraceDetail(traceLinkResponse, appMap);
            if (Objects.isNull(root)) {
                return;
            }
            createInvoke(root, appMap);
            System.out.println("kk");
        } catch (StackOverflowError e) {
            System.out.println("Caught StackOverflowError: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("ss");
        }
    }


    private InvokeTreeNode analyzeTraceDetail(TraceLinkResponse
                                                      traceLinkResponse, Map<String, Application> appMap) {
        List<LinkData> linkDataList = traceLinkResponse.getLinkDataArray();
        List<NodeData> nodeDataList = traceLinkResponse.getNodeDataArray();
        appMap.putAll(nodeDataList.stream().filter(nodeData -> !"暂未录入".equals(nodeData.getAppId()))
                .collect(Collectors.toMap(NodeData::getKey, nodeData -> {
                    Application application = new Application();
                    application.setAppId(Long.parseLong(nodeData.getAppId()));
                    application.setDomain(nodeData.getApplicationName());
                    return application;
                })));
        if (!CollectionUtils.isEmpty(linkDataList) && !CollectionUtils.isEmpty(nodeDataList)) {
            InvokeTreeNode root = TreeUtil.buildInvokeTree(linkDataList);
            updateChildrenValues(root, appMap);
            return root;
        }
        return null;
    }

    private void createInvoke(InvokeTreeNode root, Map<String, Application> appMap) {
        if (root.getChildren().isEmpty()) {
            return;
        }
        for (InvokeTreeNode child : root.getChildren()) {
            if (appMap.containsKey(root.getValue())) {
                Long sourceAppId = appMap.get(root.getValue()).getAppId();
                Long targetAppId = appMap.get(child.getValue()).getAppId();
                if (!sourceAppId.equals(targetAppId) && !invokeIsExisted(sourceAppId, targetAppId)) {
                    //避免重复创建
                    applicationRepository.createInvokeRelationship(sourceAppId, targetAppId);
                }
            }
            createInvoke(child, appMap);
        }
    }

    private boolean invokeIsExisted(Long sourceAppId, Long targetAppId) {
        if (sourceAppId == null || targetAppId == null) {
            return false;
        }
        Application application = applicationRepository.findByAppId(sourceAppId);
        List<Invoke> invokeList = application.getInvokes();
        for (Invoke invoke : invokeList) {
            Application app = invoke.getTargetApp();
            if (targetAppId.equals(app.getAppId())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 如果子节点的不是Application，子节点重命名为父节点
     *
     * @param root
     */
    private void updateChildrenValues(InvokeTreeNode root, Map<String, Application> appMap) {
        if (root == null) {
            return;
        }
        for (InvokeTreeNode child : root.getChildren()) {
            if (!appMap.containsKey(child.getValue())) {
                child.setValue(root.getValue());
            }
            updateChildrenValues(child, appMap);
        }
    }


    @Override
    public void createOwnedByRelationship() {
        List<Application> applicationList = applicationService.getAllApplication();
        applicationList.forEach(application -> {
            applicationRepository.createOwnedByRelationship(application.getAppId(), application.getOwner(), application.getL1Biz(), application.getL2Biz());
        });
    }

    @Override
    public void createExistInRelationship() {
        List<Instance> instanceList = instanceService.findAllInstance();
        for (Instance instance : instanceList) {
            instanceRepository.createExistInRelationship(instance.getName(), instance.getHostIp());
        }
    }

}
