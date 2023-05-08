package com.bookclub.service.impl;


import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("wishlistDao")
public class MongoWishlistDao implements WishlistDao {
//    private final MongoTemplate mongoTemplate;
    @Autowired
    private  MongoTemplate mongoTemplate;


    public MongoWishlistDao() {
    }

    @Override
    public List<WishlistItem> list() {
        return mongoTemplate.findAll(WishlistItem.class);
    }

    @Override
    public WishlistItem find(String key) {
        return null;
    }

    public void add(WishlistItem entity) {
        mongoTemplate.save(entity);
    }

    @Override
    public void update(WishlistItem entity) {
        //TODO:implement update method

    }

    @Override
    public boolean remove(WishlistItem entity) {
        return false;
    }


    public WishlistItem findById(String id) {
        return null;
    }
}