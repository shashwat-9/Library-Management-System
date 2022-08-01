package com.shashwat.LibraryManagementSystem.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String title;

    private String edition;

    private int totalCopies;

    private int availableCopies;

    @ManyToOne
    private BookCategory bookCategory;

    @ManyToMany
    private Set<Author> authorsList;

    public Book() {
    }

    public Book(String title, String edition, int totalCopies, int availableCopies, BookCategory bookCategory, Set<Author> authorsList) {
        this.title = title;
        this.edition = edition;
        this.totalCopies = totalCopies;
        this.availableCopies = availableCopies;
        this.bookCategory = bookCategory;
        this.authorsList = authorsList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public void setTotalCopies(int totalCopies) {
        this.totalCopies = totalCopies;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    public BookCategory getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(BookCategory bookCategory) {
        this.bookCategory = bookCategory;
    }

    public Set<Author> getAuthorsList() {
        return authorsList;
    }

    public void setAuthorsList(Set<Author> authorsList) {
        this.authorsList = authorsList;
    }

    public void addAuthors(Set<Author> authors) {
        authorsList.addAll(authors);
    }

}
