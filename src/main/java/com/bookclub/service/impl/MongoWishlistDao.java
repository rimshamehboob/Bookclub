package com.bookclub.service.impl;


//import com.bookclub.model.WishlistItem;
import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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
    public List<WishlistItem> list(String username) {
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is(username));
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
        WishlistItem wishlistItem;
        wishlistItem = mongoTemplate.findById(entity.getId(),WishlistItem.class);

        if(wishlistItem != null){
            wishlistItem.setIsbn(entity.getIsbn());
            wishlistItem.setTitle(entity.getTitle());
            wishlistItem.setUsername(entity.getUsername());

            mongoTemplate.save(wishlistItem);
        }


    }

    @Override
    public boolean remove(WishlistItem entity) {
        return false;
    }

    @Override
    public boolean remove(String key) {
      Query query = new Query();
      query.addCriteria(Criteria.where("id").is(key));
      mongoTemplate.remove(query, WishlistItem.class);
      return true;
    }




    public WishlistItem findById(String id) {
        return null;
    }
}