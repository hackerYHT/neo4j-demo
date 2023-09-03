package com.tao.neo4jdemo.repository.business;

import com.tao.neo4jdemo.entity.business.HostMachine;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * @author yehaitao01
 */
public interface HostMachineRepository  extends Neo4jRepository<HostMachine, String> {
    HostMachine findByIp(String ip);
}
