package com.tao.neo4jdemo.scheduler;

import com.tao.neo4jdemo.Service.business.RelationshipService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author yehaitao01
 */
@Slf4j
@Component
@ConditionalOnProperty(name = "neo4j.sync,invoke,relationship.job.enabled", havingValue = "true")
public class SyncInvokeJob {

    @Autowired
    private RelationshipService relationshipService;

    @Scheduled(cron = "${neo4j.sync,invoke,relationship.job.cronstr}")
    public void syncInvoke(){
    }

}
