package com.tao.neo4jdemo.entity.application.relationship;

import com.tao.neo4jdemo.entity.application.Application;
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
public class BelongTo {

    @RelationshipId
    private Long id;

    @TargetNode
    private Application application;

    @Property("type")
    private String type;

}
