package com.shashwat.LibraryManagementSystem.Repository;

import com.shashwat.LibraryManagementSystem.models.Books.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    List<Author> findAuthorByName(String title);

    Author findById(int id);

    @Override
    List<Author> findAll();

    //    Boolean existsById(int id);

}
