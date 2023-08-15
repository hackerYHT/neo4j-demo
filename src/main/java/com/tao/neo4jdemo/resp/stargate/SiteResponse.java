package com.tao.neo4jdemo.resp.stargate;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author yehaitao01
 */
@Data
public class SiteResponse {
    public Date insertTime;

    public String insertBy;

    public Date updateTime;

    public String updateBy;

    private Long id;

    private String appId;

    private String name;

    private String environment;

    private String appName;

    private String domain;

    private String appType;

    private String owner;

    private String department;

    private String departmentCode;

    private String description;

    private String zoneType;

    private List<String> zones;

    private Boolean enableHa;

    private Boolean enableMq;

    private Boolean enableJob;

    private Boolean enableVersion;

    private Boolean enableStaticResource;

    private Boolean enableUpdate;
}
