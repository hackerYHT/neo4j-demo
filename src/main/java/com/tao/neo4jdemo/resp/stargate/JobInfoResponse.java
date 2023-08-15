package com.tao.neo4jdemo.resp.stargate;

import com.tao.neo4jdemo.enums.stargate.JobStatusEnum;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author yehaitao01
 */
@Data
public class JobInfoResponse {
    private Long id;

    private String name;

    private Long siteId;

    private Long groupId;

    private String operationType;

    private String operationTypeDesc;

    private String assignInstance;

    private Long threadId;

    private JobStatusEnum status;

    private String additionalInfo;

    private Map<String, Object> dataMap;

    private Integer expireTime = 300;

    private int version;

    private Date insertTime;

    private String insertBy;

    private Date updateTime;

    private String updateBy;

    private List<TaskInfoResponse> taskInfos = new ArrayList<>();
}
