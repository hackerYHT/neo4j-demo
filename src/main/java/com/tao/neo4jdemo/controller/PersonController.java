package com.tao.neo4jdemo.controller;

import com.tao.neo4jdemo.Service.business.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yehaitao01
 */
@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/importData")
    public String importData(){
        personService.importData();
        return "import success";
    }
}
