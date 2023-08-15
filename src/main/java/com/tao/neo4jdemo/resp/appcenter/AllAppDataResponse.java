package com.tao.neo4jdemo.resp.appcenter;

import lombok.Data;

/**
 * @author yehaitao01
 */
@Data
public class AllAppDataResponse {

    private int code;
    private AllAppData data;
    private String msg;

}
