package com.xuxd.graphql.demo.graphql.scalar;

import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;
import graphql.schema.GraphQLScalarType;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * graphql.demo. Custom GraphQL scalar type: Date type ==> pattern: yyyy-MM-dd HH:mm:ss
 *
 * @author xuxd
 * @date 2021-06-09 19:13:14
 * @description graphql.demo
 **/
public class GraphQLScalarDateType extends GraphQLScalarType {

    private static final String NAME = "Date";

    private static final String PATTERN = "yyyy-MM-dd HH:mm:ss";

    private static final String DESCRIPTION = "Date scalar: " + PATTERN;

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat(PATTERN);

    public GraphQLScalarDateType() {
        this(NAME, DESCRIPTION, new DateCoercing());
    }

    public GraphQLScalarDateType(String name, String description, Coercing coercing) {
        super(name, description, coercing);
    }

    static class DateCoercing implements Coercing<Date, String> {

        // 输出序列化，返回查询结果
        @Override public String serialize(Object dataFetcherResult) throws CoercingSerializeException {
            return DATE_FORMAT.format(dataFetcherResult);
        }

        // 输入，将查询参数转换为运行时的java对象
        @Override public Date parseValue(Object input) throws CoercingParseValueException {
            String dateStr = String.valueOf(input);
            try {
                return DATE_FORMAT.parse(dateStr);
            } catch (ParseException e) {
                throw new CoercingParseValueException("Can not parse: " + dateStr + " as a Date object");
            }
        }

        @Override public Date parseLiteral(Object input) throws CoercingParseLiteralException {
            String dateStr = String.valueOf(input);
            try {
                return DATE_FORMAT.parse(dateStr);
            } catch (ParseException e) {
                throw new CoercingParseValueException("Can not parse: " + dateStr + " as a Date object");
            }
        }
    }
}
