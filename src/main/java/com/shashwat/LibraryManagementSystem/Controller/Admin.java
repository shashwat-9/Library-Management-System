package com.shashwat.LibraryManagementSystem.Controller;

import com.shashwat.LibraryManagementSystem.DAO.ReceivedAuthor;
import com.shashwat.LibraryManagementSystem.DAO.ReceivedBook;
import com.shashwat.LibraryManagementSystem.Repository.AuthorRepository;
import com.shashwat.LibraryManagementSystem.Repository.BookCategoryRepository;
import com.shashwat.LibraryManagementSystem.Repository.BookRepository;
import com.shashwat.LibraryManagementSystem.models.Author;
import com.shashwat.LibraryManagementSystem.models.Book;
import com.shashwat.LibraryManagementSystem.models.BookCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class Admin {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookCategoryRepository bookCategoryRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @PostMapping("/addNewBook")
    public List<Boolean> addNewBook(@RequestBody List<ReceivedBook> book) {
        List<Boolean> response = new ArrayList<>();

        for (ReceivedBook b: book) {
            String title = b.getTitle();
            int availableCopies = b.getAvailableCopies();
            int totalCopies = b.getTotalCopies();
            String edition = b.getEdition();
            List<Integer> authorList = b.getAuthorList();

            Optional<BookCategory> bookCategory = bookCategoryRepository.findById(b.getBookCategoryId());

            boolean flag = false;
            Set<Author> authors = new HashSet<>();
            for (int i : authorList) {
                Optional<Author> a = authorRepository.findById(i);
                if (!a.isPresent()) {
                    flag = true;
                    break;
                }
                authors.add(a.get());
            }

            if (flag || title == null || (totalCopies < availableCopies) || !bookCategory.isPresent()) {
                response.add(Boolean.FALSE);
                continue;
            }

            Book book1 = new Book(title, edition, totalCopies, availableCopies, bookCategory.get(), authors);
            bookRepository.save(book1);
            response.add(Boolean.TRUE);
        }
        return response;
    }

    @PostMapping("/addAuthor")
    public void addAuthor(@RequestBody List<ReceivedAuthor> authors) {

    }



}
