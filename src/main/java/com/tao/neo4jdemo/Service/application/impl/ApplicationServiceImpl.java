package com.tao.neo4jdemo.Service.application.impl;

import com.tao.neo4jdemo.Service.application.ApplicationService;
import com.tao.neo4jdemo.entity.application.Application;
import com.tao.neo4jdemo.repository.application.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yehaitao01
 */
@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    public List<Application> getAllApplication(){
        return applicationRepository.findAll();
    }

    public Application findByAppId(Integer appId){
        return applicationRepository.findByAppId(appId);
    }

    public void saveAndUpdateApplication(Application application){
        Application res = applicationRepository.save(application);
        System.out.println("保存成功！");
    }

    @Override
    public void deleteApplication(Integer appId) {
        applicationRepository.deleteById(appId);
        System.out.println("删除成功！");
    }

}
