package com.tao.neo4jdemo.repository.business;

import com.tao.neo4jdemo.entity.business.Interface;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

/**
 * @author yehaitao01
 */
public interface InterfaceRepository extends Neo4jRepository<Interface, Long> {

    @Query("match (n:Interface),(m:Application) where ID(n)=$id and m.name=$appName create (n) -[:DEFINED_IN]-> (m) ")
    void createInterfaceToAppRelationship(Long id, String appName);

}
