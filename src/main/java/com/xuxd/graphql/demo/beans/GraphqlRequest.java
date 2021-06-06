package com.xuxd.graphql.demo.beans;

import java.util.HashMap;
import java.util.Map;
import lombok.Data;

/**
 * GraphqlRequest.
 *
 * @author xuxd
 * @date 2021-06-03 11:22:00
 * @description GraphqlRequest.
 **/
@Data
public class GraphqlRequest {

    private String query;

    private Map<String, Object> variables = new HashMap<>();
}
