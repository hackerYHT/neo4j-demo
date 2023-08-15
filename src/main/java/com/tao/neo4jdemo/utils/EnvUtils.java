package com.tao.neo4jdemo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author yehaitao01
 */
@Component
public class EnvUtils {

    @Autowired
    private Environment environment;

    public String getEnv() {
        return environment.getProperty("env", "fat");
    }
}
