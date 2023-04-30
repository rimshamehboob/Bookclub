package com.bookclub.service.dao;

import com.bookclub.model.WishlistItem;

import java.util.List;

public interface WishlistDao extends GenericCrudDao<WishlistItem,String>{
    WishlistItem findById(String id);

}
