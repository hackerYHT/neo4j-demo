package com.tao.neo4jdemo.constant;

/**
 * @author yehaitao01
 */
public interface PeripheralConstants {
    /**
     * stargate
     */
    String GET_LATEST_RELEASE_URL_PATH = "/api/releases/lastrelease";

    String GET_INSTANCE_URL_PATH = "/api/instances/cloud";

    String GET_INSTANCE_LIST_PATH = "/api/cloud/instance/getall2";

    String GET_APP_CONTAINER_LIST_PATH = "/api/init/appinstance";

    String MESH = "mesh";

    String INTERFACE_MARKET_LIST_CATALOG_URL = "http://wiki.ppdaicorp.com/voyager/website/getCatalogList";

    String INTERFACE_MARKET_LIST_VERSION_URL = "http://wiki.ppdaicorp.com/voyager/website/versionList";

    String INTERFACE_MARKET_GET_WEBSITEINFO_URL = "http://wiki.ppdaicorp.com/voyager/website/getWebsiteInfo";

}
