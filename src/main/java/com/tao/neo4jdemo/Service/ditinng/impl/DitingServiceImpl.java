package com.tao.neo4jdemo.Service.ditinng.impl;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.TypeReference;
import com.tao.neo4jdemo.BaseException;
import com.tao.neo4jdemo.Service.client.JsonHttpClient;
import com.tao.neo4jdemo.Service.ditinng.DitingService;
import com.tao.neo4jdemo.req.DitingTraceReq;
import com.tao.neo4jdemo.resp.Dditing.DitingTraceRespone;
import com.tao.neo4jdemo.resp.Dditing.QueryParam;
import com.tao.neo4jdemo.resp.Dditing.TraceContent;
import com.tao.neo4jdemo.resp.Dditing.TraceLinkResponse;
import com.tao.neo4jdemo.resp.Response;
import lombok.extern.slf4j.Slf4j;
import org.neo4j.driver.internal.shaded.io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author yehaitao01
 */
@Service
@Slf4j
public class DitingServiceImpl implements DitingService {

    @Autowired
    private JsonHttpClient jsonHttpClient;

    @Autowired
    private Environment environment;


    @Override
    public TraceLinkResponse getTraceDetailByTraceId(String traceId) {
        if(StringUtil.isNullOrEmpty(traceId)){
            throw new IllegalArgumentException("traceId is empty");
        }
        try {
            String url = environment.getProperty("diting.fetch.invoke.link.details.url", "http://appmonitor.ppdaicorp.com/api/trace/topology/info");
            url +="?traceId=" + traceId;
            Response<TraceLinkResponse> response = jsonHttpClient.doGet(url, new TypeReference<Response<TraceLinkResponse>>() {
            });
            if (response.getCode() != 1) {
                BaseException.throwNewErrorException(String.format("调用谛听查询调用链details接口异常,msg:%s", response.getMessage()));
            }
            if(!Objects.isNull(response.getDetail())){
                return response.getDetail();
            }
        } catch (IOException e) {
            log.error("get diting invoke link error, appName:{},", traceId, e);
            BaseException.throwNewErrorException(String.format("调用谛听查询调用链detail接口异常,msg:%s", e.getMessage()));
        }
        return null;
    }

    @Override
    public List<TraceContent> getTraces(String appName){
        if(StringUtil.isNullOrEmpty(appName)){
            throw new IllegalArgumentException("appName is empty");
        }
        try {
            List<QueryParam> queryParamList = Stream.of(
                    QueryParam.builder().paramName("queryOrder").paramVal("descend").build(),
                    QueryParam.builder().paramName("queryOrderName").paramVal("execTime").build(),
                    QueryParam.builder().paramName("peerEndpointNameQuery").paramVal(String.format("{\"peerName\":\"%s\"}", appName)).build()
            ).collect(Collectors.toList());
            long currentTimestamp = System.currentTimeMillis();
            long oneHourAgoTimestamp = currentTimestamp - 3600 * 1000 * 24; // 3600秒 * 1000毫秒 * 6
            String endTime = DateUtil.format(new Date(currentTimestamp), DatePattern.UTC_PATTERN);
            String startTime = DateUtil.format(new Date(oneHourAgoTimestamp), DatePattern.UTC_PATTERN);
//            String startTime = environment.getProperty("diting.fetch.trace.start.time");
//            String endTime = environment.getProperty("diting.fetch.trace.end.time");
            String url = environment.getProperty("diting.trace.list.url", "http://appmonitor.ppdaicorp.com/api/trace/list");
            DitingTraceReq ditingTraceReq = DitingTraceReq.builder()
                    .startTime(startTime)
                    .endTime(endTime)
                    .params(queryParamList)
                    .page(1)
                    .size(15)
                    .querySky(true).build();
            Response<DitingTraceRespone<TraceContent>> response = jsonHttpClient.doPost(url, ditingTraceReq, new TypeReference<Response<DitingTraceRespone<TraceContent>>>() {
            });
            if (response.getCode() != 1) {
                BaseException.throwNewErrorException(String.format("调用谛听查询调用链trace接口异常,msg:%s", response.getMessage()));
            }
            if(!Objects.isNull(response.getDetail()) && !Objects.isNull(response.getDetail().getContent())){
                return response.getDetail().getContent();
            }
        } catch (IOException e) {
            log.error("get diting invoke link error, appName:{},", appName, e);
            BaseException.throwNewErrorException(String.format("调用谛听查询调用链trace接口异常,msg:%s", e.getMessage()));
        }
        return null;
    }
}
