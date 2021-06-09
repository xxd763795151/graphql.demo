package com.xuxd.graphql.demo.beans;

import java.util.Date;
import lombok.Data;

@Data
public class Item {

    private long id;

    private String name;

    private String code;

    private Long createTime;

    private Date searchDate;
}
