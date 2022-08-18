package com.shashwat.LibraryManagementSystem.Controller.Public.Query;

import com.shashwat.LibraryManagementSystem.Utils.Repo.RepoObj;
import com.shashwat.LibraryManagementSystem.models.Books.Author;
import com.shashwat.LibraryManagementSystem.models.Books.Book;
import com.shashwat.LibraryManagementSystem.models.Books.BookCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookQuery {

    /**
     * @param title - keyword to be searched
     * @param choice - 1 for Book title, 2 for author name, 3 for bookCategory
     * */

    @GetMapping("/searchBooks")
    public List<Book> search(@RequestParam String title, @RequestParam int choice) {
        if (title == null)  return null;
        List<Book> response = new ArrayList<>();
        switch (choice) {
            case 1:
                response = RepoObj.bookRepository.findBookByTitle(title);
                break;
            case 2:
                List<Author> author = RepoObj.authorRepository.findAuthorByName(title);
                for (Author a : author)
                    response.addAll(RepoObj.bookRepository.findBooksByAuthorsListContaining(a));
                break;
            case 3:
                BookCategory bookCategory = RepoObj.bookCategoryRepository.findByTitle(title);
                response = RepoObj.bookRepository.findBooksByBookCategory(bookCategory);
        }
        return response;
    }

    /**
     * Api for getting all the Books in the DB, paged by the size of
     * max 100
     * @param page - the page no. of the page returned
     * @param size - size of each page
     * */

    @GetMapping("/searchAllBooks")
    public Page<Book> searchAll(@RequestParam int size, @RequestParam int page) {
        if (size > 100) size = 100;
        return RepoObj.bookRepository.findAll(PageRequest.of(page, size));
    }

    @GetMapping("/allBookCategory")
    public List<BookCategory> getBookCategory() {
        return RepoObj.bookCategoryRepository.findAll();
    }

}
