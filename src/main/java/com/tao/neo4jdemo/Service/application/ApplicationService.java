package com.tao.neo4jdemo.Service.application;

import com.tao.neo4jdemo.entity.application.Application;

import java.util.List;

/**
 * @author yehaitao01
 */
public interface ApplicationService {

    List<Application> getAllApplication();

    Application findByAppId(Long appId);

    void saveAndUpdateApplication(Application application);

    void deleteApplication(Long appId);

    void batchInsertApp(List<Application> applicationList);

}
