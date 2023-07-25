package com.tao.neo4jdemo.entity.movie;

import com.tao.neo4jdemo.entity.movie.relationship.Review;
import com.tao.neo4jdemo.entity.movie.relationship.Role;
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

    @Relationship(type = "ACTED_IN", direction = Relationship.Direction.INCOMING)
    private List<Role> actorsAndRoles;

    @Relationship(type = "DIRECTED", direction = Relationship.Direction.INCOMING)
    private List<Person> directors;

    @Relationship(type = "REVIEWED", direction = Relationship.Direction.INCOMING)
    private List<Review> reviews;

}

