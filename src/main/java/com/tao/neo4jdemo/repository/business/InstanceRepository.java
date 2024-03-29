package com.tao.neo4jdemo.repository.business;

import com.tao.neo4jdemo.entity.business.Instance;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

/**
 * @author yehaitao01
 */
public interface InstanceRepository extends Neo4jRepository<Instance, String> {

    Instance findByName(String name);

    @Query("MATCH (n:Instance)-[:EXIST_IN]->(m:HostMachine{ip:$ip}) RETURN n")
    List<Instance> getAllInstanceByHostMachineIp(String ip);

    @Query("match (n:Instance)-[BELONG_TO]-> (m:Application{name:$name}) return n")
    List<Instance> getAllInstanceByAppName(String name);

    @Query("match (n:Instance),(m:HostMachine) where n.name=$name and m.ip=$hostIp create (n) -[:EXIST_IN]-> (m) ")
    void createExistInRelationship(String name, String hostIp);
}
