package com.tao.neo4jdemo.controller;

import com.tao.neo4jdemo.Service.application.ApplicationService;
import com.tao.neo4jdemo.entity.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public Application findByAppId(@RequestParam Integer appId) {
        return applicationService.findByAppId(appId);
    }

    @GetMapping("saveAndUpdateApplication")
    public String saveAndUpdateApplication(@RequestParam Integer appId,
                                @RequestParam String domain,
                                @RequestParam String l1Biz,
                                @RequestParam String l2Biz,
                                @RequestParam String owner,
                                @RequestParam String language) {
        applicationService.saveAndUpdateApplication(Application.builder()
                .appId(appId).domain(domain).l1Biz(l1Biz).l2Biz(l2Biz).owner(owner).language(language).build());
        return "保存并更新成功！";
    }

    @GetMapping("/deleteApplication")
    public String deleteApplication(@RequestParam Integer appId) {
        applicationService.deleteApplication(appId);
        return "删除成功！";
    }
}
