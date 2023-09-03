package com.tao.neo4jdemo.repository.relationship;

import com.tao.neo4jdemo.entity.business.relationship.Invoke;
import org.neo4j.driver.Record;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

/**
 * @author yehaitao01
 */
public interface InvokeRepository extends Neo4jRepository<Invoke, Long> {

    @Query("match p = (n:Application) -[r:INVOKE]-> (m:Application) where n.appId=$sourceAppId and m.appId=$targetAppId return r ")
    Record queryInvokeRelationship(Long sourceAppId, Long targetAppId);

}
