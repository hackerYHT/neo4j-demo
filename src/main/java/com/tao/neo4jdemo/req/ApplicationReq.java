package com.tao.neo4jdemo.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yehaitao01
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationReq {

    private Long appId;

    private String language;

    private String domain;

    private String owner;

    private String l1Biz;

    private String l2Biz;
}
