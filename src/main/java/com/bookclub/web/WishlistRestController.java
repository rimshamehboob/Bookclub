package com.bookclub.web;


import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;
import com.bookclub.service.impl.MongoWishlistDao;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/wishlist", produces = "application/json")
@CrossOrigin(origins = "*")
public class WishlistRestController {

    private  MongoTemplate mongoTemplate;
    private  WishlistDao wishlistDao;

    public WishlistRestController(MongoTemplate mongoTemplate, WishlistDao wishlistDao) {
        this.wishlistDao = new MongoWishlistDao();
        this.mongoTemplate = mongoTemplate;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<WishlistItem> showWishlist(){
        return wishlistDao.list();
    }
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public WishlistItem findById(@PathVariable String id) {
        return wishlistDao.find(id);
    }


}
