package com.xuxd.graphql.demo.graphql.resolver;

import com.xuxd.graphql.demo.beans.Item;
import com.xuxd.graphql.demo.beans.ItemList;
import com.xuxd.graphql.demo.beans.Param;
import com.xuxd.graphql.demo.service.IItemService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;

/**
 * graphql.demo.
 *
 * @author xuxd
 * @date 2021-06-06 18:48:32
 * @description graphql.demo
 **/
public class ItemResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    private IItemService itemService;

    public ItemResolver(IItemService itemService) {
        this.itemService = itemService;
    }

    // 对应item.graphqls里的queryItemList
    public ItemList queryItemList() {
        return itemService.queryItemList();
    }

    public Item queryById(Long id) {
        return itemService.queryById(id);
    }

    public Item updateName(Param param) {
        return itemService.updateName(param);
    }
}
