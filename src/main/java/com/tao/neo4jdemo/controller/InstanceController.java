package com.tao.neo4jdemo.controller;

import com.tao.neo4jdemo.Service.business.InstanceService;
import com.tao.neo4jdemo.entity.business.Instance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yehaitao01
 */
@RestController
@RequestMapping("/api/instance")
public class InstanceController {

    @Autowired
    private InstanceService instanceService;

    @GetMapping("/getAllInstance")
    public List<Instance> getAllInstance() {
        List<Instance> instanceList = instanceService.findAllInstance();
        return instanceList;
    }

    @GetMapping("/getInstance")
    public Instance getInstanceByName(@RequestParam String name) {
        Instance instance = instanceService.findInstanceByName(name);
        return instance;
    }

//    @PostMapping("/saveAndUpdateInstance")
//    public String saveAndUpdateInstance(@RequestBody InstanceReq instanceReq) {
//        instanceService.saveAndUpdateInstance(Instance.builder()
//                .name(instanceReq.getName())
//                .baremetal(instanceReq.getBaremetal())
//                .ip(instanceReq.getIp())
//                .port(instanceReq.getPort()).build());
//        return "保存并更新成功！";
//    }

    @DeleteMapping("/deleteInstance")
    public String deleteInstance(@RequestParam String name) {
        instanceService.deleteInstance(name);
        return "删除成功！";
    }

    @GetMapping("/getAllInstanceByHostMachineIp")
    public List<Instance> getAllInstanceByHostMachineIp(@RequestParam String ip) {
        return instanceService.getAllInstanceByHostMachineIp(ip);
    }

    @GetMapping("/getAllInstanceByAppName")
    public List<Instance> getAllInstanceByAppName(@RequestParam String name) {
        return instanceService.getAllInstanceByAppName(name);
    }

}
