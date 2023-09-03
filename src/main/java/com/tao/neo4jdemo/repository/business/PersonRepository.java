package com.tao.neo4jdemo.repository.business;

import com.tao.neo4jdemo.entity.business.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * @author yehaitao01
 */
public interface PersonRepository extends Neo4jRepository<Person, Long> {

}
