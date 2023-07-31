package com.tao.neo4jdemo.entity.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yehaitao01
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InstanceReq {

    private String name;

    private String ip;

    private String port;

    private String baremetal;
}
