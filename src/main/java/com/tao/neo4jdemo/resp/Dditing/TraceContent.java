package com.tao.neo4jdemo.resp.Dditing;

import lombok.Data;

import java.util.List;

/**
 * @author yehaitao01
 */
@Data
public class TraceContent {

    private String key;
    private String traceId;
    private String timestamp;
    private String traceTime;
    private String serviceName;
    private String execTime;
    private String client;
    private String clientIp;
    private String server;
    private String serverIp;
    private String httpCode;
    private String clientInfo;
    private String serverInfo;
    private int status;
    private String env;
    private String cluster;
    private int hasException;
    private String traceDetail;
    private String firstSpanType;
    private String[] timeRange;
    private String[] tags;
    private List<String> businessKeyList;

}
