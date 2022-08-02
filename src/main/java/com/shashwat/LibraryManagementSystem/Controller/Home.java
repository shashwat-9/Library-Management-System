package com.shashwat.LibraryManagementSystem.Controller;

import com.shashwat.LibraryManagementSystem.DAO.SearchRequest;
import com.shashwat.LibraryManagementSystem.Repository.AuthorRepository;
import com.shashwat.LibraryManagementSystem.Repository.BookCategoryRepository;
import com.shashwat.LibraryManagementSystem.Repository.BookRepository;
import com.shashwat.LibraryManagementSystem.models.Books.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Home {

    @Autowired
    private BookCategoryRepository bookCategoryRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/")
    public String home() {
        return "welcome";
    }

    @GetMapping("/search")
    public List<Object> getBooks(@RequestBody SearchRequest searchRequest) {
        List<Book> books = new ArrayList<>();
    }

}
