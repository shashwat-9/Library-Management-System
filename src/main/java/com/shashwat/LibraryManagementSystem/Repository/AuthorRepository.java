package com.shashwat.LibraryManagementSystem.Repository;

import com.shashwat.LibraryManagementSystem.models.Books.Author;
import com.shashwat.LibraryManagementSystem.models.Books.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    List<Author> findAuthorByName(String title);

    Author findById(int id);

//    List<Author> findAuthorsByNameLikeIgnoreCase(String name);


    List<Author> findAuthorsByNameContainingIgnoreCase(String name);
    @Override
    List<Author> findAll();

    List<Author> findAuthorsByBookCategory(BookCategory bookCategory);

}
