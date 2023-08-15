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

    @Override
    public List<Application> getAllApplication(){
        return applicationRepository.findAll();
    }

    @Override
    public Application findByAppId(Long appId){
        return applicationRepository.findByAppId(appId);
    }

    @Override
    public void saveAndUpdateApplication(Application application){
        Application res = applicationRepository.save(application);
        System.out.println("保存成功！");
    }

    @Override
    public void deleteApplication(Long appId) {
        applicationRepository.deleteById(appId);
        System.out.println("删除成功！");
    }

    @Override
    public void batchInsertApp(List<Application> applicationList) {
        applicationRepository.saveAll(applicationList);
    }

}
