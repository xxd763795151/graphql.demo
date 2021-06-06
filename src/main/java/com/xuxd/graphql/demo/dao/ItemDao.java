package com.xuxd.graphql.demo.dao;

import com.xuxd.graphql.demo.beans.Item;
import com.xuxd.graphql.demo.beans.ItemList;
import com.xuxd.graphql.demo.beans.Param;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * graphql.demo.
 *
 * @author xuxd
 * @date 2021-06-06 18:54:59
 * @description graphql.demo
 **/
// 可以考虑根据实际相关框架如Mybatis，但是这里并不是实际的从数据库等查询数据，因此仅是一个demo，硬编码返回数据
@Component
public class ItemDao {

    private static final Map<Long, Item> ITEM_CACHE = new HashMap<>();

    static {
        ITEM_CACHE.put(1L, item(1L, "java"));
        ITEM_CACHE.put(2L, item(2L, "c"));
        ITEM_CACHE.put(3L, item(3L, "c++"));
        ITEM_CACHE.put(4L, item(4L, "go"));
    }

    public ItemList queryItemList() {
        ItemList itemList = new ItemList();
        itemList.setItemList(new ArrayList<>(ITEM_CACHE.values()));
        itemList.setTotal(ITEM_CACHE.size());

        return itemList;
    }

    public Item queryById(Long id) {
        return ITEM_CACHE.get(id);
    }

    public Item updateName(Param param) {
        Item item = ITEM_CACHE.get(param.getId());
        item.setName(param.getName());
        return item;
    }

    private static Item item(Long id, String code) {
        Item item = new Item();
        item.setId(id);
        item.setCode(code);
        item.setName(code + "项目");
        return item;
    }
}
