package com.tao.neo4jdemo.resp.stargate;

import lombok.Data;

import java.util.List;

/**
 * @author hanxiantao
 */
@Data
public class StargatePageResponse<T> {

    private List<T> content;

    private long totalElements;

    private int totalPages;

    private boolean last;

    private boolean first;

    private int numberOfElements;

    private int size;

    private int number;

}
