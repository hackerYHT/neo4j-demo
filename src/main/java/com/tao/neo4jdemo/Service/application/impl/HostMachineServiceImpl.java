package com.tao.neo4jdemo.Service.application.impl;

import com.tao.neo4jdemo.Service.application.HostMachineService;
import com.tao.neo4jdemo.entity.application.HostMachine;
import com.tao.neo4jdemo.repository.application.HostMachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yehaitao01
 */
@Service
public class HostMachineServiceImpl implements HostMachineService {

    @Autowired
    private HostMachineRepository hostMachineRepository;
    @Override
    public List<HostMachine> findAllHostMachine() {
        return hostMachineRepository.findAll();
    }

    @Override
    public HostMachine getHostMachineByIp(String ip) {
        return hostMachineRepository.findByIp(ip);
    }

    @Override
    public void saveAndUpdateHostMachine(HostMachine build) {
        hostMachineRepository.save(build);
    }

    @Override
    public void deleteHostMachine(String ip) {
        hostMachineRepository.deleteById(ip);
    }
}
