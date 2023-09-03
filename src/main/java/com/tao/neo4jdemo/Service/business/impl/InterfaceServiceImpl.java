package com.tao.neo4jdemo.Service.business.impl;

import com.tao.neo4jdemo.Service.business.InterfaceService;
import com.tao.neo4jdemo.Service.interfaceMarket.InterfaceMarketService;
import com.tao.neo4jdemo.entity.business.Interface;
import com.tao.neo4jdemo.repository.business.InterfaceRepository;
import com.tao.neo4jdemo.resp.interfaceMarket.Catalog;
import com.tao.neo4jdemo.resp.interfaceMarket.InterfaceDetail;
import com.tao.neo4jdemo.resp.interfaceMarket.InterfaceInfo;
import com.tao.neo4jdemo.resp.interfaceMarket.Version;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author yehaitao01
 */
@Service
@Slf4j
public class InterfaceServiceImpl implements InterfaceService {

    @Autowired
    private InterfaceMarketService interfaceMarketService;

    @Autowired
    private InterfaceRepository interfaceRepository;

    @Override
    public void batchInertInterfaceNode() {
        List<Catalog> catalogList = interfaceMarketService.getMarketAppList();
        List<String> appNameList = analyze(catalogList);
        for (String appName : appNameList) {
            List<Version> versionList = interfaceMarketService.getAppVersionListByAppName(appName);
            Version version = new Version();
            for (Version v : versionList) {
                if (v.isCurrentVersion()) {
                    version = v;
                    break;
                }
            }
            List<InterfaceInfo> list = interfaceMarketService.getAppInterfaceInfos(appName, "", version.getVersion(), version.isCurrentVersion());
            for (InterfaceInfo interfaceInfo : list) {
                List<InterfaceDetail> interfaceDetailList = interfaceInfo.getInterfaceInfoList();
                for (InterfaceDetail interfaceDetail : interfaceDetailList) {
                    Interface itf = Interface.builder()
                            .summary(interfaceDetail.getSummary())
                            .httpMethod(interfaceDetail.getHttpMethod())
                            .pathUrl(interfaceDetail.getPathUrl())
                            .tag(interfaceDetail.getTag()).build();
                    Interface res = interfaceRepository.save(itf);
                    interfaceRepository.createInterfaceToAppRelationship(res.getId(), appName);
                }
            }
        }
    }

    private List<String> analyze(List<Catalog> catalogList) {
        List<String> appNamList = new ArrayList<>();
        if (CollectionUtils.isEmpty(catalogList)) {
            return new ArrayList<>();
        }
        for (Catalog catalog : catalogList) {
            depthFirstTraversal(catalog, appNamList);
        }
        return appNamList;
    }

    private void depthFirstTraversal(Catalog catalog, List<String> appNameList) {
        if (Objects.isNull(catalog)) {
            return;
        }
        List<Catalog> children = catalog.getChildren();
        if (CollectionUtils.isEmpty(children)) {
            appNameList.add(catalog.getLabel());
            return;
        }
        for (Catalog child : children) {
            depthFirstTraversal(child, appNameList);
        }
    }

}
