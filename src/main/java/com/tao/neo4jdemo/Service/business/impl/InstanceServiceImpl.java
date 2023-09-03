package com.tao.neo4jdemo.Service.business.impl;

import com.tao.neo4jdemo.Service.business.InstanceService;
import com.tao.neo4jdemo.entity.business.Instance;
import com.tao.neo4jdemo.repository.business.InstanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yehaitao01
 */
@Service
public class InstanceServiceImpl implements InstanceService {

    @Autowired
    private InstanceRepository instanceRepository;

    @Override
    public List<Instance> findAllInstance(){
        return instanceRepository.findAll();
    }

    @Override
    public Instance findInstanceByName(String name) {
        return instanceRepository.findByName(name);
    }

    @Override
    public void saveAndUpdateInstance(Instance instance) {
        Instance instance1 = instanceRepository.save(instance);
        System.out.println("保存成功！");
    }

    @Override
    public void deleteInstance(String name) {
        instanceRepository.deleteById(name);
    }

    @Override
    public List<Instance> getAllInstanceByHostMachineIp(String ip) {
        return instanceRepository.getAllInstanceByHostMachineIp(ip);
    }

    @Override
    public List<Instance> getAllInstanceByAppName(String name) {
        return instanceRepository.getAllInstanceByAppName(name);
    }

    @Override
    public void batchSaveInstances(List<Instance> instancesList) {
        instanceRepository.saveAll(instancesList);
    }

    @Override
    public List<Instance> getAllInstance() {
        return instanceRepository.findAll();
    }

}
