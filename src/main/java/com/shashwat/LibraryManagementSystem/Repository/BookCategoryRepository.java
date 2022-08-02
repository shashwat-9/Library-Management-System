package com.shashwat.LibraryManagementSystem.Repository;

import com.shashwat.LibraryManagementSystem.models.Books.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCategoryRepository extends JpaRepository<BookCategory, Integer> {
}
