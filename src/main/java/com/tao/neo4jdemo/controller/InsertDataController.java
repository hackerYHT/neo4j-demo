package com.tao.neo4jdemo.controller;

import com.tao.neo4jdemo.Service.business.ImportDataService;
import com.tao.neo4jdemo.resp.WebResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yehaitao01
 */
@RestController
@RequestMapping("/api/importData")
public class InsertDataController {
    @Autowired
    private ImportDataService importDataService;

    @PostMapping("/insertApplications")
    public WebResponse<String> insertApplications() {
        importDataService.insertApplications();
        return WebResponse.success("插入成功！");
    }

    @PostMapping("/insertInstances")
    public WebResponse<String> insertInstances() {
        importDataService.insertInstances();
        return WebResponse.success("插入成功！");
    }


}
