package com.tao.neo4jdemo.entity.business;

import com.tao.neo4jdemo.entity.business.relationship.BelongTo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

/**
 * @author yehaitao01
 */
@Node("Instance")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Instance {

    @Id
    private String name;

    private Long groupId;
    private String env;
    private String zone;
    private String appName;
    private String image;
    private String spec;
    private Integer port;
    private String instanceIp;
    private String hostIp;
    private String cpu;
    private String memory;
    private String containerStatus;
    private Boolean ready;
    private Long startTime;
    private String containerConsoleUrl;

}
