package com.xuxd.graphql.demo.graphql.resolver;

import graphql.kickstart.tools.GraphQLQueryResolver;

/**
 * graphql.demo. Base and common query resolver.
 *
 * @author xuxd
 * @date 2021-06-06 18:57:38
 * @description graphql.demo
 **/
public class Query implements GraphQLQueryResolver {

    private String version = "1.0";
}
