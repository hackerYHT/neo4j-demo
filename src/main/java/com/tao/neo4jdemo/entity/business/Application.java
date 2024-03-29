package com.tao.neo4jdemo.entity.business;

import com.tao.neo4jdemo.entity.business.relationship.BelongTo;
import com.tao.neo4jdemo.entity.business.relationship.Invoke;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.*;

import java.util.List;

/**
 * @author yehaitao01
 */
@Node("Application")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Application {
    @Id
    private Long appId;
    @Property("language")
    private String language;
    @Property("name")
    private String domain;
    private String owner;
    private String l1Biz;
    private String l2Biz;
    private String app_type;
    private String description;
    private String importance;
    private String status;


    @Relationship(type = "INVOKE", direction = Relationship.Direction.OUTGOING)
    private List<Invoke> invokes;

}
