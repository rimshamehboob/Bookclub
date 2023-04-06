package com.Bookclub.BookClub.service.impl;

import com.Bookclub.BookClub.model.Book;
import com.Bookclub.BookClub.model.WishlistItem;
import com.Bookclub.BookClub.service.dao.WishListDao;

import java.util.ArrayList;
import java.util.List;

public class memWishlistDao implements WishListDao {

    private List<WishlistItem> wishlistItemList;

    public memWishlistDao() {
        this.wishlistItemList = new ArrayList<>();

        for(int x=0;x<5;x++)
        {
            WishlistItem w_item = new WishlistItem();
            w_item.setIsbn("ISBN-#001");
            w_item.setTitle("BOOK-title");

            this.wishlistItemList.add(w_item);

        }
    }
    @Override
    public List<WishlistItem> list() {
        return this.wishlistItemList;
    }

    @Override
    public WishlistItem find(String key) {
        return null;
    }
    //TODO: WRITE METHODS TO IMPLEMENT list() and find()
    //In the classes constructor populate a
    //private property called wishlist of type List<WishlistItem>. Return this array in the list()
    //method and use this array to return a matching object by isbn. Use the work you
    //completed in the MemBookDao as a baseline for how to write the Java code
}
