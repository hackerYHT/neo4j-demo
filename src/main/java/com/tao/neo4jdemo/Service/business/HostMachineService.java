package com.tao.neo4jdemo.Service.business;

import com.tao.neo4jdemo.entity.business.HostMachine;

import java.util.List;

/**
 * @author yehaitao01
 */
public interface HostMachineService {

    List<HostMachine> findAllHostMachine();

    HostMachine getHostMachineByIp(String ip);

    void saveAndUpdateHostMachine(HostMachine build);

    void deleteHostMachine(String ip);

    void importData();
}
