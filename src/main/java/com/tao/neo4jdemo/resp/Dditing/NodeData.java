package com.tao.neo4jdemo.resp.Dditing;

import lombok.Data;

import java.util.List;

/**
 * @author yehaitao01
 */
@Data
public class NodeData {
    private String key;
    private String applicationName;
    private String serviceName;
    private String name;
    private String img;
    private String source;
    private String serviceType;
    private List<String> instanceList;
    private String manager;
    private String testManager;
    private String department;
    private String appId;
    private List<String> env;
    private String info;
    private String envStr;
    private String cluster;
    private String traceId;
    private boolean hasException;
    private String callHasException;
    private List<String> rawEnv;
}
