package com.tao.neo4jdemo.entity.application.relationship;

import com.tao.neo4jdemo.entity.application.Database;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

/**
 * @author yehaitao01
 */
@RelationshipProperties
@Data
public class InvokeDatabase {

    @RelationshipId
    private Long id;

    @TargetNode
    private Database database;

    @Property("protocal")
    private String protocal;
}
