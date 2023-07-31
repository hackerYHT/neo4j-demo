package com.tao.neo4jdemo.entity.application;

import com.tao.neo4jdemo.entity.application.relationship.ExistIn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

/**
 * @author yehaitao01
 */
@Node("HostMachine")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HostMachine {

    @Id
    private String ip;

    @Relationship(type = "EXIST_IN", direction = Relationship.Direction.INCOMING)
    private List<ExistIn> existInList;

}
