package com.bookclub.BookClub.web;

import com.bookclub.BookClub.model.WishlistItem;
import com.bookclub.BookClub.service.dao.WishlistDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/wishlist", produces = "application/json")
@CrossOrigin(origins = "*")
public class WishlistRestController {

    @Autowired
    private WishlistDao wishlistDao;

    public WishlistRestController(WishlistDao wishlistDao) {
        this.wishlistDao = wishlistDao;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<WishlistItem> showWishlistItem(){
        return wishlistDao.list();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public WishlistItem findById(@PathVariable String id){
        return wishlistDao.find(id);
    }
}
