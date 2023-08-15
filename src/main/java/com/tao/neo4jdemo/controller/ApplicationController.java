package com.tao.neo4jdemo.controller;

import com.tao.neo4jdemo.Service.application.ApplicationService;
import com.tao.neo4jdemo.entity.application.Application;
import com.tao.neo4jdemo.entity.req.ApplicationReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yehaitao01
 */
@RestController
@RequestMapping("/api/application")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @GetMapping("/getAllApplication")
    public List<Application> getAllApplication() {
        return applicationService.getAllApplication();
    }

    @GetMapping("/findByAppId")
    public Application findByAppId(@RequestParam Long appId) {
        return applicationService.findByAppId(appId);
    }

    @PostMapping("saveAndUpdateApplication")
    public String saveAndUpdateApplication(@RequestBody ApplicationReq applicationReq) {
        applicationService.saveAndUpdateApplication(Application.builder()
                .appId(applicationReq.getAppId())
                .domain(applicationReq.getDomain())
                .l1Biz(applicationReq.getL1Biz())
                .l2Biz(applicationReq.getL2Biz())
                .owner(applicationReq.getOwner())
                .language(applicationReq.getLanguage()).build());
        return "保存并更新成功！";
    }

    @DeleteMapping("/deleteApplication")
    public String deleteApplication(@RequestParam Long appId) {
        applicationService.deleteApplication(appId);
        return "删除成功！";
    }
}
