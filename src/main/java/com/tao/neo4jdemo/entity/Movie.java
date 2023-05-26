package com.tao.neo4jdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.*;

import java.util.List;

/**
 * @author yehaitao01
 */
@Node("Movie")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    @GeneratedValue
    private Long id;

    @Property("title")
    private String title;

    @Property("tagline")
    private String tagline;

    @Property("released")
    private Integer released;

    // 注意这些关系最终的箭头指向是当前实体，即TargetNode（Person）->当前定义Relationship的实体（Movie）
    // 定义一个关系（参演）[direction]
    @Relationship(type = "ACTED_IN", direction = Relationship.Direction.INCOMING)
    private List<Role> actorsAndRoles;

    // 定义一个关系（导演）
    @Relationship(type = "DIRECTED", direction = Relationship.Direction.INCOMING)
    private List<Person> directors;

    // 定义一个关系（评论）
    @Relationship(type = "REVIEWED", direction = Relationship.Direction.INCOMING)
    private List<Review> reviews;

}

