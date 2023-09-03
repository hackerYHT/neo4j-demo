package com.tao.neo4jdemo.repository.business;

import com.tao.neo4jdemo.entity.business.Application;
import com.tao.neo4jdemo.entity.business.relationship.Invoke;
import org.neo4j.driver.Record;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

/**
 * @author yehaitao01
 */
public interface ApplicationRepository extends Neo4jRepository<Application, Long> {

    Application findByAppId(Long appId);

    Application findByDomain(String appName);

    @Query("match (n:Application),(m:Instance) where n.appId=$appId and m.name=$instanceName create (m) -[:BELONG_TO]-> (n) ")
    void createRelationship4AppInstance(Long appId, String instanceName);

    @Query("match (n:Application),(m:Application) where n.appId=$sourceAppId and m.appId=$targetAppId create (n) -[:INVOKE]-> (m) ")
    void createInvokeRelationship(long sourceAppId, long targetAppId);

    @Query("match (n:Application),(m:Person) where n.appId=$appId and m.name=$personName and m.l1Biz=$l1Biz and m.l2Biz=$l2Biz create (n) -[:OWNED_BY]-> (m) ")
    void createOwnedByRelationship(Long appId, String personName, String l1Biz, String l2Biz);

//    @Query("match p = (n:Application) -[r:INVOKE]-> (m:Application) where n.appId=$sourceAppId and m.appId=$targetAppId return r ")
//    Record queryInvokeRelationship(Long sourceAppId, Long targetAppId);

}
