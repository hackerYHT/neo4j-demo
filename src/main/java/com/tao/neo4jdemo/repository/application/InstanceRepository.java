package com.tao.neo4jdemo.repository.application;

import com.tao.neo4jdemo.entity.application.Application;
import com.tao.neo4jdemo.entity.application.Instance;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

/**
 * @author yehaitao01
 */
public interface InstanceRepository  extends Neo4jRepository<Instance, String> {

    Instance findByName(String name);
}
