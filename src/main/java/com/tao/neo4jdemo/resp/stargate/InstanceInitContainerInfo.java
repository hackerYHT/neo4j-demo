package com.tao.neo4jdemo.resp.stargate;

import lombok.Data;

import java.util.Date;

/**
 * @author yehaitao01
 */
@Data
public class InstanceInitContainerInfo {

    private Date insertTime;
    private String insertBy;
    private Date updateTime;
    private String updateBy;
    private Boolean isActive;
    private Long id;
    private Long initContainerTypeId;
    private String env;
    private String version;
    private Boolean switchFlag;
    private String subenv;
    private Long instanceId;
    private String appId;
    private String currVersion;
    private Boolean currSwitchFlag;
    private String ip;

}
