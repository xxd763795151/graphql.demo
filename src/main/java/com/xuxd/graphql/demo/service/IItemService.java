package com.xuxd.graphql.demo.service;

import com.xuxd.graphql.demo.beans.Item;
import com.xuxd.graphql.demo.beans.ItemList;
import com.xuxd.graphql.demo.beans.Param;

/**
 * graphql.demo.
 *
 * @author xuxd
 * @date 2021-06-06 18:54:03
 * @description graphql.demo
 **/
public interface IItemService {

    ItemList queryItemList();

    Item queryById(Long id);

    Item updateName(Param param);
}
