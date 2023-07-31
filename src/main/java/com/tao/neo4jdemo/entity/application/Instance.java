package com.tao.neo4jdemo.entity.application;

import com.tao.neo4jdemo.entity.application.relationship.BelongTo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

/**
 * @author yehaitao01
 */
@Node("Instance")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Instance {

    @Id
    private String name;

    private Long id;

    private String ip;

    private String port;

    private String baremetal;

    @Relationship(type = "BELONG_TO", direction = Relationship.Direction.OUTGOING)
    private BelongTo belongTo;

}
