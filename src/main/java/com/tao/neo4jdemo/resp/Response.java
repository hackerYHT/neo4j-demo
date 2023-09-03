package com.tao.neo4jdemo.resp;

import lombok.Data;

/**
 * @author yehaitao01
 */
@Data
public class Response <T>{

    private Integer code;

    private String message;

    private T detail;

    private String stackTrace;
}
