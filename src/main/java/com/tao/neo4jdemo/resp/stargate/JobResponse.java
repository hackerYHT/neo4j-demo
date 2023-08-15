package com.tao.neo4jdemo.resp.stargate;

import com.tao.neo4jdemo.enums.stargate.JobStatusEnum;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author yehaitao01
 */
@Data
public class JobResponse {
    private Long id;

    private String name;

    private Long siteId;

    private Long groupId;

    private String operationType;

    private String operationTypeDesc;

    private String assignInstance;

    private Long threadId;

    private Integer expireTime;

    private JobStatusEnum status;

    private String dataMap;

    private Integer version;

    private List<TaskInfoResponse> taskList;

    private Date insertTime;

    private String insertBy;

    private Date updateTime;

    private String updateBy;

    private SiteResponse site;

    private String ip;
}
