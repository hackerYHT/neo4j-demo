package com.tao.neo4jdemo.resp.Dditing;

import lombok.Data;

import java.util.List;

/**
 * @author yehaitao01
 */
@Data
public class DitingTraceRespone<T> {
    private int totalElements;
    private List<T> content;
}
