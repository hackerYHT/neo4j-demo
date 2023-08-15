/**
  * Copyright 2022 json.cn 
  */
package com.tao.neo4jdemo.resp.appcenter;
import lombok.Data;

import java.util.List;

/**
 * @author yehaitao01
 */
@Data
public class Tags {

    private List<String> country;
    private List<String> taint;

}