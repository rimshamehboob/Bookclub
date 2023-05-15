package com.bookclub.service.dao;

import java.util.List;

public interface GenericCrudDao<E,K> {
    List<E> list(String username); //Return a list of objects of type E
    E find(K key); //Return an object of type E by type K value

    void add(E entity);
    void update(E entity);

    boolean remove(E entity);
}
