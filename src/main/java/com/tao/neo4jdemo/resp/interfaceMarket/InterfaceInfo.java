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
public class InterfaceInfo {
    private String tag;
    private List<InterfaceDetail> interfaceInfoList;

}
