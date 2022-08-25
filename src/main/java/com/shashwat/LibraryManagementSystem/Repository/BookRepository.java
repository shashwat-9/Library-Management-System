package com.shashwat.LibraryManagementSystem.Repository;

import com.shashwat.LibraryManagementSystem.models.Books.Author;
import com.shashwat.LibraryManagementSystem.models.Books.Book;
import com.shashwat.LibraryManagementSystem.models.Books.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findBooksByAuthorsListContaining(Author author);
    List<Book> findBookByTitle(String title);
//    List<Book> findBooksByAuthorsList(List<Author> authors);
    List<Book> findBooksByBookCategory(BookCategory bookCategory);

    Book findById(int id);

    @Transactional
    @Modifying
    @Query("update Book book set book.availableCopies =:change where book.id =:id")
    void changeAvailableCopies(int id, int change);

}
