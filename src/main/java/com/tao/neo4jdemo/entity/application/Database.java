package com.tao.neo4jdemo.entity.application;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

import java.util.List;

/**
 * @author yehaitao01
 */
@Node("Database")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Database {
    @Id
    @GeneratedValue
    private Long id;

    @Property("name")
    private String domain;

    private String ip;

    private String port;

    private String type;

}
