package com.tao.neo4jdemo.resp.interfaceMarket;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yehaitao01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Version {
    private String version;
    private boolean currentVersion;
}
