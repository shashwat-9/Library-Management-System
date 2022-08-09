package com.shashwat.LibraryManagementSystem.POJOs;

import java.util.List;

public class ReceivedBook {
    private String title;
    private int availableCopies;
    private int totalCopies;
    private String edition;
    private int bookCategoryId;
    private List<Integer> authorList;

    public ReceivedBook() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public void setTotalCopies(int totalCopies) {
        this.totalCopies = totalCopies;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public int getBookCategoryId() {
        return bookCategoryId;
    }

    public void setBookCategoryId(int bookCategoryId) {
        this.bookCategoryId = bookCategoryId;
    }

    public List<Integer> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Integer> authorList) {
        this.authorList = authorList;
    }
}
