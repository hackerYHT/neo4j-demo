package com.tao.neo4jdemo.entity.application;

import com.tao.neo4jdemo.entity.application.relationship.BelongTo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

/**
 * @author yehaitao01
 */
@Node("Instance")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Instance {

    @Id
    @GeneratedValue
    private Long id;

    private String ip;

    private String port;

    private String name;

    private String baremetal;

    @Relationship(type = "BELONG_TO", direction = Relationship.Direction.OUTGOING)
    private BelongTo belongTo;

}
