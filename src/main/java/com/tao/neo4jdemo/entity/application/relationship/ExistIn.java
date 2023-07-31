package com.tao.neo4jdemo.entity.application.relationship;

import com.tao.neo4jdemo.entity.application.Instance;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

/**
 * @author yehaitao01
 */
@RelationshipProperties
@Data
public class ExistIn {

    @RelationshipId
    private Long id;

    @TargetNode
    private final Instance instance;

}
