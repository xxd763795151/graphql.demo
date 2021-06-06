package com.xuxd.graphql.demo.service.impl;

import com.xuxd.graphql.demo.beans.Item;
import com.xuxd.graphql.demo.beans.ItemList;
import com.xuxd.graphql.demo.beans.Param;
import com.xuxd.graphql.demo.dao.ItemDao;
import com.xuxd.graphql.demo.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * graphql.demo.
 *
 * @author xuxd
 * @date 2021-06-06 18:54:27
 * @description graphql.demo
 **/
@Service
public class ItemServiceImpl implements IItemService {

    @Autowired
    private ItemDao itemDao;

    @Override public ItemList queryItemList() {
        return itemDao.queryItemList();
    }

    @Override public Item queryById(Long id) {
        return itemDao.queryById(id);
    }

    @Override public Item updateName(Param param) {
        return itemDao.updateName(param);
    }
}
