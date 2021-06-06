package com.xuxd.graphql.demo.beans;

import java.util.List;
import lombok.Data;

@Data
public class ItemList {

    private List<Item> itemList;

    private int total;
}
