package com.tao.neo4jdemo.Service.appcenter.impl;

import com.tao.neo4jdemo.Service.appcenter.AppcenterService;
import com.tao.neo4jdemo.Service.client.JsonHttpClient;
import com.tao.neo4jdemo.resp.appcenter.AllAppDataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yehaitao01
 */
@Service
public class AppcenterServiceImpl implements AppcenterService {

    @Autowired
    private Environment environment;

    @Autowired
    private JsonHttpClient jsonHttpClient;

    @Override
    public AllAppDataResponse getAllAppData() {
        String panguUrl = environment.getProperty("pangu.thirdapi.server.allapp", String.class, "");

        try {
            Map<String, String> header = new HashMap<>(16);
            String auth = environment.getProperty("pangu.server.authkey", String.class, "");
            header.put("Authorization", auth);

            AllAppDataResponse allAppDataResponse = jsonHttpClient.get(panguUrl, header, AllAppDataResponse.class);
            return allAppDataResponse;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
