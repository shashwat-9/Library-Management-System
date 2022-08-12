package com.shashwat.LibraryManagementSystem.Controller;

import com.shashwat.LibraryManagementSystem.POJOs.CreateUserRequest;
import com.shashwat.LibraryManagementSystem.Utils.Create.CreateInstance;
import com.shashwat.LibraryManagementSystem.Utils.Messages.Messages;
import com.shashwat.LibraryManagementSystem.Utils.Repo.RepoObj;
import com.shashwat.LibraryManagementSystem.Service.Validators.BookValidator;
import com.shashwat.LibraryManagementSystem.models.Admin.Notification;
import com.shashwat.LibraryManagementSystem.models.Books.Author;
import com.shashwat.LibraryManagementSystem.models.Books.Book;
import com.shashwat.LibraryManagementSystem.models.Books.BookCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Home {

    /**
     * Basic welcome API
     * */
    @GetMapping("/welcome")
    public String welcome() {
        return "WELCOME TO CENTRAL LIBRARY";
    }

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

    @GetMapping("/allAuthor")
    public List<Author> getAuthor() {return RepoObj.authorRepository.findAll();}

    /**
     * Api used for fetching notifications sorted Date-Wise
     * */
    @GetMapping("/notifications")
    public Page<Notification>  getNotifications(@RequestParam int size,@RequestParam int page) {
        Sort sort = Sort.by("Date").descending();
        return RepoObj.notificationRepository.findAll(PageRequest.of(page, size, sort));
    }

    /**
     * @param createUserRequest - An Object having details of the UserSignUp.
     * Click for more details
     * This API first checks for the validity of the details of the UserSignUp
     * Upon successful verification,the instance of the UserSignUp object is saved
     * User is disabled by default when signup is successful, which can be approved by the head only
     */

    @PostMapping("/signUp")
    public ResponseEntity<String> signUp(@RequestBody CreateUserRequest createUserRequest) {

        int isValid = BookValidator.userValidator(createUserRequest);
        if (isValid != 4) {
            return new ResponseEntity<>(Messages.UserSignUp[isValid], HttpStatus.NOT_ACCEPTABLE);
        }
        try {
            RepoObj.userRepository.save(CreateInstance.createUser(createUserRequest));
        } catch (Exception e) {
            return new ResponseEntity<>(Messages.UserSignUp[7], HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(Messages.UserSignUp[4], HttpStatus.CREATED);
    }
}