package com.tao.neo4jdemo.resp.stargate;

import com.tao.neo4jdemo.enums.stargate.TaskStatusEnum;
import lombok.Data;

import java.util.Date;
import java.util.Map;

/**
 * @author yehaitao01
 */
@Data
public class TaskInfoResponse {
    private Long id;

    private String name;

    private String description;

    private Long jobId;

    private Long instanceId;

    private Map<String, Object> dataMap;

    private TaskStatusEnum status;

    private String additionalInfo;

    private int step;

    private Integer expireTime = 0;

    private Date startTime;

    private Date endTime;

    private Date insertTime;

    private String insertBy;

    private Date updateTime;

    private String updateBy;

    private JobInfoResponse jobInfo;
}
