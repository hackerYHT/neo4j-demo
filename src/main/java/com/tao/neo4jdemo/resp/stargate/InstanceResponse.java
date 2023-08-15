package com.tao.neo4jdemo.resp.stargate;

import lombok.Data;

import java.util.Date;

/**
 * @author yehaitao01
 */
@Data
public class InstanceResponse {

    private Long id;

    private String name;

    private String env;

    private Long groupId;

    private String appId;

    private String slotId;

    private String slotIp;

    private Integer port;

    private String envVars;

    private String status;

    private Boolean hasPulledIn;

    private Integer weight;

    private Long slbSiteServerId;

    private String image;

    private String zone;

    private String spec;

    private String namespace;

    private String timezone;

    private Date releaseTime;

    private Date modifyTime;

    private Boolean isStressAgentActive;

    private Boolean isDitingAgentActive;

    private String ditingVersion;

    private String stressVersion;

    private Long containertimeDeltaSecs;

    private Boolean isIdcOnline;

    private String xinyeIdc;

    private Boolean oldPulledIn;

    private Boolean isCoverageEnable;

    private Boolean isDeploying;

    private Boolean isTransfer;

    private String area;

    private String cloudType;

    private Boolean isRecovering;

    private Integer currentRetryNum;

    public Date insertTime;

    public String insertBy;

    public Date updateTime;

    public String updateBy;

    public Boolean isActive;
}
