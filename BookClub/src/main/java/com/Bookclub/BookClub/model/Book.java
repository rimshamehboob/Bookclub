package com.Bookclub.BookClub.model;

import java.util.List;

public class Book {
    private String isbn;
    private String title;
    private String description;
    private int numOfPages;

    List<String> authors;

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }
}
