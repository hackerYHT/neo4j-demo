package com.tao.neo4jdemo.entity.application;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Node;

/**
 * @author yehaitao01
 */
@Node("HostMachine")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HostMachine {

    private String ip;

}
