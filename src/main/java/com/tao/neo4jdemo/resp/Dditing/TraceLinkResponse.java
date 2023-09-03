package com.tao.neo4jdemo.resp.Dditing;

import lombok.Data;

import java.util.List;

/**
 * @author yehaitao01
 */
@Data
public class TraceLinkResponse {

    private int angle;
    private String range;
    private String timeRange;
    private String root;
    private int size;
    private List<NodeData> nodeDataArray;
    private List<LinkData> linkDataArray;


}
