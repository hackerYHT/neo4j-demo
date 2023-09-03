package com.tao.neo4jdemo.Service.stargate.impl;

import cn.hutool.core.lang.TypeReference;
import com.tao.neo4jdemo.BaseException;
import com.tao.neo4jdemo.Service.client.JsonHttpClient;
import com.tao.neo4jdemo.Service.stargate.StargateService;
import com.tao.neo4jdemo.req.InstanceRequest;
import com.tao.neo4jdemo.resp.stargate.InstanceInfoResponse;
import com.tao.neo4jdemo.resp.stargate.InstanceResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.List;

import static com.tao.neo4jdemo.constant.ConfigConstants.ADAPT_LIMIT_STARGATE_ADDRESS;
import static com.tao.neo4jdemo.constant.PeripheralConstants.GET_INSTANCE_LIST_PATH;

/**
 * @author yehaitao01
 */
@Slf4j
@Service
public class StargateServiceImpl implements StargateService {

    @Autowired
    private Environment environment;

    @Autowired
    private JsonHttpClient jsonHttpClient;

    @Override
    public List<InstanceResp> getAllInstanceInfo(String env) {
        if (StringUtils.isEmpty(env)) {
            throw new IllegalArgumentException("env is empty");
        }
        try {
            String url = getStargateAddress() + GET_INSTANCE_LIST_PATH;
            InstanceInfoResponse<List<InstanceResp>> response = jsonHttpClient.doPost(url, InstanceRequest.builder().env(env).build(), new TypeReference<InstanceInfoResponse<List<InstanceResp>>>() {
            });
            if (response.getCode() != 0) {
                BaseException.throwNewErrorException(String.format("调用stargate查询所有应用实例信息接口异常,msg:%s", response.getMessage()));
            }
            List<InstanceResp> instanceResps = response.getInstances();
            return instanceResps;
        } catch (IOException e) {
            log.error("getAllInstanceInfo error!,", e);
            BaseException.throwNewErrorException(String.format("调用stargate查询应用实例信息接口异常,msg:%s", e.getMessage()));
        }
        return null;
    }

    private String getStargateAddress() {
        return environment.getProperty(ADAPT_LIMIT_STARGATE_ADDRESS, String.class, "http://dev-stargate.ppdaicorp.com");
    }

}
