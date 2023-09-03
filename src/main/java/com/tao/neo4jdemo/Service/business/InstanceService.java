package com.tao.neo4jdemo.Service.business;

import com.tao.neo4jdemo.entity.business.Instance;

import java.util.List;

/**
 * @author yehaitao01
 */
public interface InstanceService {
    List<Instance> findAllInstance();

    Instance findInstanceByName(String name);

    void saveAndUpdateInstance(Instance build);

    void deleteInstance(String name);

    List<Instance> getAllInstanceByHostMachineIp(String ip);

    List<Instance> getAllInstanceByAppName(String name);

    void batchSaveInstances(List<Instance> instancesList);

    List<Instance> getAllInstance();

}
