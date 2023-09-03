package com.tao.neo4jdemo.entity.business;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

/**
 * @author yehaitao01
 */
@Node("Interface")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Interface {

    @Id
    @GeneratedValue
    private Long id;

    private String pathUrl;
    private String summary;
    private String httpMethod;
    private String tag;

}
