package com.tao.neo4jdemo.resp.stargate;

import lombok.Data;

/**
 * @author yehaitao01
 */
@Data
public class InstanceResp {

    private Long groupId;
    private String env;
    private String zone;
    private String name;
    private String appName;
    private String image;
    private String spec;
    private Integer port;
    private String instanceIp;
    private String hostIp;
    private String cpu;
    private String memory;
    private String containerStatus;
    private Boolean ready;
    private Long startTime;
    private String containerConsoleUrl;

}
