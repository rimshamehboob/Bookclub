package com.bookclub.service.dao;

import java.util.List;

public interface GenericDao<E, K> {
    List<E> list();

    E find(K key);
}