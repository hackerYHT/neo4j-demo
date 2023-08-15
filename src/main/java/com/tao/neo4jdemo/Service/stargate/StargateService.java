package com.tao.neo4jdemo.Service.stargate;

import com.tao.neo4jdemo.resp.stargate.InstanceResp;

import java.util.List;

/**
 * @author yehaitao01
 */
public interface StargateService {


    /**
     * 获取所有实例的信息
     * @param env
     * @return
     */
    List<InstanceResp> getAllInstanceInfo(String env);


}
