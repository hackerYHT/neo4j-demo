package com.tao.neo4jdemo.entity;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

/**
 * @author yehaitao01
 */
@Data
@Node("Person")
public class Person {

    @Id
    private String name;

    @Property("born")
    private Long born;

    public Person(Long born, String name) {
        this.born = born;
        this.name = name;
    }

}
