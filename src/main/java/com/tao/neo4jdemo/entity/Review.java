package com.tao.neo4jdemo.entity;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

/**
 * @author yehaitao01
 */
@RelationshipProperties
@Data
public class Review {

    @RelationshipId
    private Long id;

    private String summary;

    private Integer rating;

    @TargetNode
    private Person reviewer;

}
