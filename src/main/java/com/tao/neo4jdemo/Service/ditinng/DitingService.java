package com.tao.neo4jdemo.Service.ditinng;

import com.tao.neo4jdemo.resp.Dditing.TraceContent;
import com.tao.neo4jdemo.resp.Dditing.TraceLinkResponse;

import java.util.List;

/**
 * @author yehaitao01
 */
public interface DitingService {

    TraceLinkResponse getTraceDetailByTraceId(String traceId);

    List<TraceContent> getTraces(String appName);

}
