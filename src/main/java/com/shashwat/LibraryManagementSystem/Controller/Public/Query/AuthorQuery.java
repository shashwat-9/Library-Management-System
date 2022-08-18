package com.shashwat.LibraryManagementSystem.Controller.Public.Query;

import com.shashwat.LibraryManagementSystem.Utils.Repo.RepoObj;
import com.shashwat.LibraryManagementSystem.models.Books.Author;
import com.shashwat.LibraryManagementSystem.models.Books.BookCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorQuery {

    @GetMapping("/allAuthor")
    public List<Author> getAuthor() {return RepoObj.authorRepository.findAll();}

    @GetMapping("/allAuthorByPage")
    public Page<Author> getAuthor(@RequestParam int page,@RequestParam int size) {
        return RepoObj.authorRepository.findAll(PageRequest.of(page, size));
    }

    @GetMapping("/authorByTitle")
    public List<Author> getAuthorByTitle (@RequestParam String title) {
        return RepoObj.authorRepository.findAuthorsByNameContainingIgnoreCase(title);
    }

    @GetMapping("/authorByCategory")
    public List<Author> getAuthorByCategory (@RequestParam int categoryId) {
        BookCategory bookCategory = RepoObj.bookCategoryRepository.findById(categoryId);
        if (bookCategory == null)
            return null;
        return RepoObj.authorRepository.findAuthorsByBookCategory(bookCategory);
    }
}
