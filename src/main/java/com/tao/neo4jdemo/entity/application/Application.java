package com.tao.neo4jdemo.entity.application;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

/**
 * @author yehaitao01
 */
@Node("Application")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Application {
    @Id
    private Integer appId;

    @Property("lang")
    private String language;

    @Property("name")
    private String domain;

    private String owner;

    private String l1Biz;

    private String l2Biz;

    @Relationship(type = "BELONG_TO", direction = Relationship.Direction.INCOMING)
    private List<Instance> instances;

    // 出口关系
    @Relationship(type = "OUTGOING_RELATIONSHIP")
    private Application outgoingApplication;

    // 入口关系
    @Relationship(type = "INCOMING_RELATIONSHIP", direction = Relationship.Direction.INCOMING)
    private Application incomingApplication;

}
