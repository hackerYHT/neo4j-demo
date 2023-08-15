package com.tao.neo4jdemo.resp.stargate;

import lombok.Data;

import java.util.List;

/**
 * @author yehaitao01
 */
@Data
public class InstanceInitContainerResp {

    private List<InstanceInitContainerInfo> instances;

}
