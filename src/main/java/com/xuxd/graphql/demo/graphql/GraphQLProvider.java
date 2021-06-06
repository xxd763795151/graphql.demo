package com.xuxd.graphql.demo.graphql;

import com.xuxd.graphql.demo.graphql.resolver.ItemResolver;
import com.xuxd.graphql.demo.graphql.resolver.Mutation;
import com.xuxd.graphql.demo.graphql.resolver.Query;
import com.xuxd.graphql.demo.service.IItemService;
import graphql.GraphQL;
import graphql.kickstart.tools.SchemaParser;
import graphql.schema.GraphQLSchema;
import java.io.IOException;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * graphql.demo. GraphQL provider.
 *
 * @author xuxd
 * @date 2021-06-06 18:48:32
 * @description graphql.demo
 **/
@Component
public class GraphQLProvider {

    private GraphQL graphQL;

    @Autowired
    private IItemService itemService;

    @Bean
    public GraphQL graphQL() {
        return graphQL;
    }

    @PostConstruct
    public void init() throws IOException {
        GraphQLSchema graphQLSchema = SchemaParser.newParser()
            .file("graphql/base.graphqls")
            .resolvers(new Query(), new Mutation())
            .file("graphql/item.graphqls")
            .resolvers(new ItemResolver(itemService))
//            .file("book.graphqls")
//            .resolvers(new BookResolver())  //其它定义照上面的示例，继续增加
            .build().makeExecutableSchema();

        this.graphQL = graphQL.newGraphQL(graphQLSchema).build();
    }

}
