package com.tao.neo4jdemo.Service.business;

import com.tao.neo4jdemo.entity.business.Application;

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

    Application findByName(String appName);

}
