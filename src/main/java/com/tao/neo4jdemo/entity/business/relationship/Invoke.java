package com.tao.neo4jdemo.entity.business.relationship;

import com.tao.neo4jdemo.entity.business.Application;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

/**
 * @author yehaitao01
 */

@Data
@RelationshipProperties
public class Invoke {

    @RelationshipId
    private Long id;

    @TargetNode
    private Application targetApp;

}
