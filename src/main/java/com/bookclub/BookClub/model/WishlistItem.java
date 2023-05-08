package com.bookclub.BookClub.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;

public class WishlistItem {

    @NotNull
    @NotEmpty(message = "ISBN is a required field")
    private String isbn;
    private String title;
    @Id
    private String id;

    public WishlistItem()
    {
        this.title ="Title";
        this.isbn ="isbn";
    }

    public WishlistItem(String isbn,String title) {
        this.isbn = isbn;
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "WishListItem {"+"="+this.isbn+"title="+this.title+"}"+"title"+this.id;
    }

    public String getId() {
        return id;
    }
}

