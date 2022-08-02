package com.shashwat.LibraryManagementSystem.models.Books;

import com.sun.istack.NotNull;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String name;

    @ManyToOne
    private BookCategory bookCategory;

    public Author() {
    }

    public Author(String name, BookCategory bookCategory) {
        this.name = name;
        this.bookCategory = bookCategory;
    }

    @NotNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public BookCategory getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(BookCategory bookCategory) {
        this.bookCategory = bookCategory;
    }
}
