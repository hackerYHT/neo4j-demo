package com.tao.neo4jdemo.Service.interfaceMarket.impl;

import cn.hutool.core.lang.TypeReference;
import com.tao.neo4jdemo.BaseException;
import com.tao.neo4jdemo.Service.client.JsonHttpClient;
import com.tao.neo4jdemo.Service.interfaceMarket.InterfaceMarketService;
import com.tao.neo4jdemo.resp.interfaceMarket.Catalog;
import com.tao.neo4jdemo.resp.interfaceMarket.CatalogResponse;
import com.tao.neo4jdemo.resp.interfaceMarket.InterfaceInfo;
import com.tao.neo4jdemo.resp.interfaceMarket.Version;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

import static com.tao.neo4jdemo.constant.PeripheralConstants.*;

/**
 * @author yehaitao01
 */
@Service
@Slf4j
public class InterfaceMarketServiceImpl implements InterfaceMarketService {


    @Autowired
    private JsonHttpClient jsonHttpClient;

    @Override
    public List<Catalog> getMarketAppList() {
        try {
            String url = INTERFACE_MARKET_LIST_CATALOG_URL;
            CatalogResponse<Catalog> response = jsonHttpClient.doGet(url, new TypeReference<CatalogResponse<Catalog>>() {
            });
            if (response.getRet() != 0) {
                BaseException.throwNewErrorException(String.format("调用接口集市接口异常,msg:%s", response.getMsg()));
            }
            List<Catalog> catalogList = response.getData();
            return catalogList;
        } catch (IOException e) {
            log.error("getAllInstanceInfo error!,", e);
            BaseException.throwNewErrorException(String.format("调用接口集市接口异常,msg:%s", e.getMessage()));
        }
        return null;
    }

    @Override
    public List<Version> getAppVersionListByAppName(String appName) {
        try {
            String url = INTERFACE_MARKET_LIST_VERSION_URL + "?webSite=" + appName;
            CatalogResponse<Version> response = jsonHttpClient.doGet(url, new TypeReference<CatalogResponse<Version>>() {
            });
            if (response.getRet() != 0) {
                BaseException.throwNewErrorException(String.format("调用接口集市接口异常,msg:%s", response.getMsg()));
            }
            List<Version> versionList = response.getData();
            return versionList;
        } catch (IOException e) {
            log.error("getAllInstanceInfo error!,", e);
            BaseException.throwNewErrorException(String.format("调用接口集市接口异常,msg:%s", e.getMessage()));
        }
        return null;
    }

    @Override
    public List<InterfaceInfo> getAppInterfaceInfos(String webSite, String groupName, String version, boolean isCurrentVersion) {
        try {
            String url = INTERFACE_MARKET_GET_WEBSITEINFO_URL + "?webSite=" + webSite + "&groupName=" + groupName + "&version=" + version + "&isCurrentVersion=" + isCurrentVersion;
            CatalogResponse<InterfaceInfo> response = jsonHttpClient.doGet(url, new TypeReference<CatalogResponse<InterfaceInfo>>() {
            });
            if (response.getRet() != 0) {
                BaseException.throwNewErrorException(String.format("调用接口集市接口异常,msg:%s", response.getMsg()));
            }
            List<InterfaceInfo> interfaceInfoList = response.getData();
            return interfaceInfoList;
        } catch (IOException e) {
            log.error("getAllInstanceInfo error!,", e);
            BaseException.throwNewErrorException(String.format("调用接口集市接口异常,msg:%s", e.getMessage()));
        }
        return null;
    }


}
