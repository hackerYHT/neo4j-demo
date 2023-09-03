package com.tao.neo4jdemo.entity.business.relationship;

import com.tao.neo4jdemo.entity.business.Application;
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
public class InvokeApplication {

    @RelationshipId
    private Long id;

    @TargetNode
    private Application toApp;

    @Property("protocal")
    private String type;

}
