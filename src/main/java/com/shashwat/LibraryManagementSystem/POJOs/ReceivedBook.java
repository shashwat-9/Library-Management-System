package com.shashwat.LibraryManagementSystem.DAO;

import java.util.List;

public class ReceivedBook {
    String title;
    int availableCopies;
    int totalCopies;
    String edition;
    int bookCategoryId;
    List<Integer> authorList;

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
