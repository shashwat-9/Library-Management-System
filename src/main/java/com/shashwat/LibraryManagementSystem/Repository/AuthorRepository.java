package com.shashwat.LibraryManagementSystem.Repository;

import com.shashwat.LibraryManagementSystem.models.Books.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
