package com.tao.neo4jdemo.resp.appcenter;

import lombok.Data;

import java.util.List;

/**
 * @author yehaitao01
 */
@Data
public class AllAppData {

    private int total;

    private List<AppData> data;

}
