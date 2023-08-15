package com.tao.neo4jdemo.resp.stargate;

import lombok.Data;

/**
 * @author hanxiantao
 */
@Data
public class StargateWebResponse <T> {

    private Integer code;

    private String message;

    private T details;

    private String stackTrace;
}
