package com.tao.neo4jdemo.Service.business.impl;

import com.tao.neo4jdemo.Service.business.HostMachineService;
import com.tao.neo4jdemo.Service.business.InstanceService;
import com.tao.neo4jdemo.entity.business.HostMachine;
import com.tao.neo4jdemo.entity.business.Instance;
import com.tao.neo4jdemo.repository.business.HostMachineRepository;
import org.neo4j.driver.internal.shaded.io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yehaitao01
 */
@Service
public class HostMachineServiceImpl implements HostMachineService {

    @Autowired
    private HostMachineRepository hostMachineRepository;

    @Autowired
    private InstanceService instanceService;
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

    @Override
    public void importData() {
        List<Instance> instanceList = instanceService.findAllInstance();
        List<HostMachine> hostMachineList = new ArrayList<>();
        for (Instance instance : instanceList) {
            String hostIp = instance.getHostIp();
            if(StringUtil.isNullOrEmpty(hostIp)){
                continue;
            }
            hostMachineList.add(HostMachine.builder().ip(hostIp).build());
        }
        hostMachineList = hostMachineList.stream().distinct().collect(Collectors.toList());
        hostMachineRepository.saveAll(hostMachineList);
    }
}
