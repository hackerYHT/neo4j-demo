package com.tao.neo4jdemo.Service.application.impl;

import com.tao.neo4jdemo.Service.appcenter.AppcenterService;
import com.tao.neo4jdemo.Service.application.ApplicationService;
import com.tao.neo4jdemo.Service.application.ImportDataService;
import com.tao.neo4jdemo.Service.application.InstanceService;
import com.tao.neo4jdemo.Service.stargate.StargateService;
import com.tao.neo4jdemo.entity.application.Application;
import com.tao.neo4jdemo.entity.application.Instance;
import com.tao.neo4jdemo.resp.appcenter.AllAppDataResponse;
import com.tao.neo4jdemo.resp.appcenter.AppData;
import com.tao.neo4jdemo.resp.stargate.InstanceResp;
import com.tao.neo4jdemo.utils.EnvUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yehaitao01
 */
@Service
@Slf4j
public class ImportDataServiceImpl implements ImportDataService {

    @Autowired
    private AppcenterService appcenterService;

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private InstanceService instanceService;

    @Autowired
    private StargateService stargateService;

    @Autowired
    private EnvUtils envUtils;

    @Override
    public void insertApplication() {
        AllAppDataResponse allAppDataResponse = appcenterService.getAllAppData();
        List<AppData> appDataList = allAppDataResponse.getData().getData();
        List<Application> applicationList = convert2Application(appDataList);
        applicationService.batchInsertApp(applicationList);
    }

    @Override
    public void insertInstance() {
        List<InstanceResp> instanceRespList = stargateService.getAllInstanceInfo(envUtils.getEnv());
        List<Instance> instancesList = convert2Instances(instanceRespList);
        instanceService.batchInstances(instancesList);
    }

    private List<Instance> convert2Instances(List<InstanceResp> instanceRespList) {
        List<Instance> instanceList = new ArrayList<>();
        instanceRespList.forEach(instanceResp -> {
            Instance instance = new Instance();
            BeanUtils.copyProperties(instanceResp, instance);
            instanceList.add(instance);
        });
        return instanceList;
    }

    private List<Application> convert2Application(List<AppData> appDataList) {
        List<Application> applicationList = new ArrayList<>();
        appDataList.forEach(appData -> {
            Application application = new Application();
            application.setAppId(appData.getId());
            application.setDomain(appData.getName());
            application.setLanguage(appData.getApp_language());
            application.setOwner(appData.getOwner().getFullname());
            application.setL1Biz(appData.getL1_biz().getBiz_name());
            application.setL2Biz(appData.getL2_biz().getBiz_name());
            application.setApp_type(appData.getApp_type());
            application.setImportance(appData.getImportance());
            application.setDescription(appData.getDescription());
            application.setStatus(appData.getStatus());
            applicationList.add(application);
        });
        return applicationList;
    }
}
