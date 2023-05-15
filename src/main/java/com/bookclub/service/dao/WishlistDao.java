package com.bookclub.service.dao;

import com.bookclub.model.WishlistItem;

public interface WishlistDao extends GenericCrudDao<WishlistItem,String>{
    boolean remove(String key);

    WishlistItem findById(String id);

}
