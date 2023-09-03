package com.tao.neo4jdemo.resp.Dditing;

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
public class QueryParam {

    private String paramName;
    private String paramVal;

}
