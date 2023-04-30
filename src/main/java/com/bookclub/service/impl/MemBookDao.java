package com.bookclub.service.impl;


import com.bookclub.model.Book;
import com.bookclub.service.dao.BookDao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MemBookDao implements BookDao {
    public MemBookDao() {
        this.books = new ArrayList<>();

        for(int x=0;x<5;x++)
        {
            //authors
            List<String> authors = new ArrayList<>() ;
            authors.add("neymar");
            authors.add("mbappe");
            authors.add("veratti");

            Book book = new Book();
            book.setIsbn("Book"+x+" Isbn");
            book.setTitle("Book "+x+" Title");
            book.setDescription("Book" + x+" --description");
            book.setNumOfPages(200);
            book.setAuthors(authors);

            //add book to the books list
            this.books.add(book);
        }
    }

    private List<Book> books;
    @Override
    public List<Book>list()
    {
        return this.books;
    }
    @Override
    public Book find(String key)
    {
        for(Book book:this.books) {
            if(book.getIsbn().equals(key)){
                return book;
            }
        }
        return new Book();
    }
}
