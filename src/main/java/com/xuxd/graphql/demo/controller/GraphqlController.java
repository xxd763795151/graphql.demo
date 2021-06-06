package com.xuxd.graphql.demo.controller;

import com.xuxd.graphql.demo.beans.GraphqlRequest;
import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.GraphQLError;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * GraphqlController. Handle request for GraphQL
 *
 * @author xuxd
 * @date 2021-06-03 11:17:58
 * @description GraphqlController. Handle request for GraphQL
 **/
@RestController
@RequestMapping("/graphql")
@Log
public class GraphqlController {

    @Autowired
    private GraphQL graphQL;

    @PostMapping
    public Object execute(@RequestBody GraphqlRequest request) {
        ExecutionInput executionInput = ExecutionInput.newExecutionInput()
            .query(request.getQuery())
            .variables(request.getVariables())
            .build();
        Map<String, Object> result = new HashMap<>();

        ExecutionResult executionResult = graphQL.execute(executionInput);
        List<GraphQLError> errors = executionResult.getErrors();

        if (errors != null && !errors.isEmpty()) {
            result.put("errors", errors);
            return result;
        }
        return executionResult.getData();
    }
}
