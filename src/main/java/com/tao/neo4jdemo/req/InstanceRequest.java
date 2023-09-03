package com.tao.neo4jdemo.req;

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
public class InstanceRequest {
    private String env;
}
