package com.shashwat.LibraryManagementSystem.DAO;

import com.shashwat.LibraryManagementSystem.models.Books.BookCategory;

public class ReceivedAuthor {

    private String title;
    private int bookCategory;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(int bookCategory) {
        this.bookCategory = bookCategory;
    }

}
