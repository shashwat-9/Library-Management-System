package com.shashwat.LibraryManagementSystem.Controller;

import com.shashwat.LibraryManagementSystem.POJOs.ReceivedAuthor;
import com.shashwat.LibraryManagementSystem.POJOs.ReceivedBook;
import com.shashwat.LibraryManagementSystem.Repository.AuthorRepository;
import com.shashwat.LibraryManagementSystem.Repository.BookCategoryRepository;
import com.shashwat.LibraryManagementSystem.Repository.BookRepository;
import com.shashwat.LibraryManagementSystem.Utils.Repo.RepoObj;
import com.shashwat.LibraryManagementSystem.models.Books.Author;
import com.shashwat.LibraryManagementSystem.models.Books.Book;
import com.shashwat.LibraryManagementSystem.models.Books.BookCategory;
import jdk.internal.util.xml.impl.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class Admin {

    private final RepoObj repoObj;
    @Autowired
    Admin(RepoObj repoObj) {
        this.repoObj = repoObj;
    }

    @PostMapping("/admin/addNewBook")
    public List<Map<Boolean, String>> addNewBook(@RequestBody List<ReceivedBook> book) {
        return null;
    }

    @PostMapping("/admin/addBookCategory")
    public List<Boolean> addBookCategory(List<BookCategory> bookCategoryList) {
       return null;
    }

}
