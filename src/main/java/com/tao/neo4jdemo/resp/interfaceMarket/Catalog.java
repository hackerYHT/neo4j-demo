package com.tao.neo4jdemo.resp.interfaceMarket;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author yehaitao01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Catalog {

    private String label;
    private String id;
    private int level;
    private List<Catalog> children;

}
