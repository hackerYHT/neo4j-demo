package com.tao.neo4jdemo.Service.application;

import com.tao.neo4jdemo.entity.application.HostMachine;

import java.util.List;

/**
 * @author yehaitao01
 */
public interface HostMachineService {

    List<HostMachine> findAllHostMachine();

    HostMachine getHostMachineByIp(String ip);

    void saveAndUpdateHostMachine(HostMachine build);

    void deleteHostMachine(String ip);
}
