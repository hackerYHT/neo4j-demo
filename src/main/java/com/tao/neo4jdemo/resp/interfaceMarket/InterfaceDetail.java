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
public class InterfaceDetail {
    private String summary;
    private String pathUrl;
    private String httpMethod;
    private String tag;
    private List<Param> reqList;
    private List<Param> respList;
}
