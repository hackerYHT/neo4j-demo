package com.tao.neo4jdemo.controller;

import com.tao.neo4jdemo.Service.business.InterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yehaitao01
 */
@RestController
@RequestMapping("/api/interface")
public class InterfaceController {

    @Autowired
    private InterfaceService interfaceService;

    @PostMapping("/batchInertInterfaceNode")
    public String batchInertInterfaceNode() {
        interfaceService.batchInertInterfaceNode();
        return "保存并更新成功！";
    }

}
