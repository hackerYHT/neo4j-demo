package com.tao.neo4jdemo.repository.movie;

import com.tao.neo4jdemo.entity.movie.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * @author yehaitao01
 */
@Repository
public interface PersonRepository extends Neo4jRepository<Person, String> {

}
