package com.tao.neo4jdemo.controller;

import com.tao.neo4jdemo.Service.business.RelationshipService;
import com.tao.neo4jdemo.entity.business.Application;
import com.tao.neo4jdemo.repository.business.ApplicationRepository;
import com.tao.neo4jdemo.repository.relationship.InvokeRepository;
import com.tao.neo4jdemo.resp.WebResponse;
import org.neo4j.driver.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yehaitao01
 */
@RestController
@RequestMapping("/api/relationship")
public class RelationshipController {

    @Autowired
    private RelationshipService relationshipService;

    @PostMapping("/createAllAppInstanceRelationship")
    public WebResponse<String> createAllAppInstanceRelationship() {
        relationshipService.createAllAppInstanceRelationship();
        return WebResponse.success("创建成功！");
    }

    @PostMapping("/createRelationship4AppInstance")
    public WebResponse<String> createRelationship4AppInstance(@RequestParam Long appId, @RequestParam String instanceName) {
        relationshipService.createRelationship4AppInstance(appId, instanceName);
        return WebResponse.success("创建成功！");
    }

    @Autowired
    private ApplicationRepository applicationRepository;
    @Autowired
    private InvokeRepository invokeRepository;
    @PostMapping("/createInvokeRelationShip")
    public WebResponse<String> createInvokeRelationShip() {
        relationshipService.createInvokeRelationShip();
//        relationshipService.tmp("d542b498aa3c4f1285339715338b3b24.73.26802.16925902613307771");
        return WebResponse.success("创建成功！");
    }

    @PostMapping("/createOwnedByRelationship")
    public WebResponse<String> createOwnedByRelationship() {
        relationshipService.createOwnedByRelationship();
        return WebResponse.success("创建成功！");
    }

    @PostMapping("/createExistInRelationship")
    public WebResponse<String> createExistInRelationship() {
        relationshipService.createExistInRelationship();
        return WebResponse.success("创建成功！");
    }

}
