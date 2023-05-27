package com.tao.neo4jdemo.repository.application;

import com.tao.neo4jdemo.entity.application.Application;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * @author yehaitao01
 */
public interface ApplicationRepository extends Neo4jRepository<Application, Integer> {
    Application findByAppId(Integer appId);
}
