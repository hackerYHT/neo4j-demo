package com.tao.neo4jdemo.resp.Dditing;

import lombok.Data;

/**
 * @author yehaitao01
 */
@Data
public class LinkData {
    private String from;
    private String to;
    private String text;
    private String textDetail;
    private String callIds;
    private String calls;
    private double duration;
    private double max;
    private double min;
    private double avg;
    private String status;
    private String method;
    private String serviceName;
    private int totalCount;
    private int errorCount;
    private String time;
    private String type;
    private int depth;
    private int seq;
    private boolean hasException;
    private String span;
    private String children;
}
