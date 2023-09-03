package com.tao.neo4jdemo.Service.interfaceMarket;

import com.tao.neo4jdemo.resp.interfaceMarket.Catalog;
import com.tao.neo4jdemo.resp.interfaceMarket.InterfaceInfo;
import com.tao.neo4jdemo.resp.interfaceMarket.Version;

import java.util.List;

/**
 * @author yehaitao01
 */
public interface InterfaceMarketService {

    /**
     * 获取接口集市应用信息
     *
     * @return
     */
    List<Catalog> getMarketAppList();

    /**
     * 获取appName对应的接口记录版本号
     *
     * @param appName
     * @return
     */
    List<Version> getAppVersionListByAppName(String appName);

    /**
     * 获取应用的接口信息
     * @param webSite
     * @param groupName
     * @param version
     * @param isCurrentVersion
     * @return
     */
    List<InterfaceInfo> getAppInterfaceInfos(String webSite, String groupName, String version, boolean isCurrentVersion);

}
