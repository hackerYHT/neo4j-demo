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
public class AppData {

    private String app_language;
    private String app_type;
    private String description;
    private String document_uri;
    private List<String> domain;
    private String health_check_url;
    private long id;
    private String iginte_check_url;
    private String importance;
    private boolean is_confirmed;
    private L1_biz l1_biz;
    private L2_biz l2_biz;
    private Tags tags;
    private String name;
    private List<Other_owner> other_owner;
    private Owner owner;
    private List<Port> port;
    private String status;
    private String storage_uri;
    private String mobile_platform;
    private String mobile_pack_name;

}