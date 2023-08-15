/**
  * Copyright 2022 json.cn 
  */
package com.tao.neo4jdemo.resp.appcenter;

import lombok.Data;

/**
 * @author yehaitao01
 */
@Data
public class AppDataResponse {

    private int code;
    private AppData data;
    private String msg;

}