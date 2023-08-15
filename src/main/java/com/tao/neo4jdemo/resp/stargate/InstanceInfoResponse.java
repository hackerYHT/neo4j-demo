package com.tao.neo4jdemo.resp.stargate;

import lombok.Data;

/**
 * @author yehaitao01
 */
@Data
public class InstanceInfoResponse<T> {

    private Integer code;

    private String message;

    private T instances;

}
