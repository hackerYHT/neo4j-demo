package com.tao.neo4jdemo.Service.application;

import com.tao.neo4jdemo.entity.application.Instance;

import java.util.List;

/**
 * @author yehaitao01
 */
public interface InstanceService {
    List<Instance> findAllInstance();

    Instance findInstanceByName(String name);

    void saveAndUpdateInstance(Instance build);

    void deleteInstance(String name);
}
