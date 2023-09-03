package com.tao.neo4jdemo.req;

import com.tao.neo4jdemo.resp.Dditing.QueryParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author yehaitao01
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DitingTraceReq {
    private String startTime;
    private String endTime;
    private int page;
    private int size;
    private List<QueryParam> params;
    private boolean querySky;

}
