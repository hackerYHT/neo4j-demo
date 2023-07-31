package com.tao.neo4jdemo.controller;

import com.tao.neo4jdemo.Service.application.HostMachineService;
import com.tao.neo4jdemo.Service.application.InstanceService;
import com.tao.neo4jdemo.entity.application.HostMachine;
import com.tao.neo4jdemo.entity.application.Instance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yehaitao01
 */
@RestController
@RequestMapping("/api/hostMachine")
public class HostMachineController {

    @Autowired
    private HostMachineService hostMachineService;

    @GetMapping("/getAllHostMachine")
    public List<HostMachine> getAllHostMachine() {
        List<HostMachine> hostMachines = hostMachineService.findAllHostMachine();
        return hostMachines;
    }

    @GetMapping("/getHostMachineByIp")
    public HostMachine getHostMachineByIp(@RequestParam String ip) {
        HostMachine hostMachine = hostMachineService.getHostMachineByIp(ip);
        return hostMachine;
    }

    @PostMapping("/saveAndUpdateHostMachine")
    public String saveAndUpdateHostMachine(@RequestParam String ip) {
        hostMachineService.saveAndUpdateHostMachine(HostMachine.builder().ip(ip).build());
        return "保存并更新成功！";
    }

    @DeleteMapping("/deleteHostMachine")
    public String deleteHostMachine(@RequestParam String ip) {
        hostMachineService.deleteHostMachine(ip);
        return "删除成功！";
    }

}
