package com.shashwat.LibraryManagementSystem.Controller;

import com.shashwat.LibraryManagementSystem.POJOs.CreateUserRequest;
import com.shashwat.LibraryManagementSystem.Utils.CreateInstance.CreateInstance;
import com.shashwat.LibraryManagementSystem.Utils.Messages.Messages;
import com.shashwat.LibraryManagementSystem.Utils.Repo.RepoObj;
import com.shashwat.LibraryManagementSystem.Utils.Validators.Validator;
import com.shashwat.LibraryManagementSystem.models.Admin.Notification;
import com.shashwat.LibraryManagementSystem.models.Books.Author;
import com.shashwat.LibraryManagementSystem.models.Books.Book;
import com.shashwat.LibraryManagementSystem.models.Books.BookCategory;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final RepoObj repoObj;
    @Autowired
    public Home(RepoObj repoObj) {
        this.repoObj = repoObj;
    }

    /**
     * Basic welcome API
     * */
    @GetMapping("/welcome")
    public String welcome() {
        return "WELCOME TO CENTRAL LIBRARY";
    }

    /**
     * @param title - keyword to be searched
     * @param choice - 1 for book title, 2 for author name, 3 for bookCategory
     * */
    @GetMapping("/searchBooks")
    public List<Book> search(@RequestParam String title, @RequestParam int choice) {
        if (title == null)  return null;
        List<Book> response = new ArrayList<>();
        switch (choice) {
            case 1:
                response = repoObj.bookRepository.findBookByTitle(title);
                break;
            case 2:
                List<Author> author = repoObj.authorRepository.findAuthorByName(title);
                for (Author a : author)
                    response.addAll(repoObj.bookRepository.findBooksByAuthorsListContaining(a));
                break;
            case 3:
                BookCategory bookCategory = repoObj.bookCategoryRepository.findByTitle(title);
                response = repoObj.bookRepository.findBooksByBookCategory(bookCategory);
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
        return repoObj.bookRepository.findAll(PageRequest.of(page, size));
    }

    @GetMapping("/BookCategory")
    public List<BookCategory> getBookCategory() {
        return repoObj.bookCategoryRepository.findAll();
    }


    /**
     * Api used for fetching notifications sorted Date-Wise
     * */
    @GetMapping("/notifications")
    public Page<Notification>  getNotifications(@RequestParam int size,@RequestParam int page) {
        Sort sort = Sort.by("Date").descending();
        return repoObj.notificationRepository.findAll(PageRequest.of(page, size, sort));
    }

    /**
     * @param createUserRequest - An Object having details of the user.
     * Click for more details
     * This API first checks for the validity of the details of the user
     * Upon successful verification,the instance of the user object is saved
     * User is disabled by default when signup is successful, which can be approved by the head only
     */
    @PostMapping("/signUp")
    public ResponseEntity<String> signUp(@RequestBody CreateUserRequest createUserRequest) {

        int isValid = Validator.userValidator(createUserRequest);
        if (isValid != 4) {
            return new ResponseEntity<>(Messages.user[isValid], HttpStatus.NOT_ACCEPTABLE);
        }
        repoObj.userRepository.save(CreateInstance.createUser(createUserRequest));

        return new ResponseEntity<>(Messages.user[4], HttpStatus.CREATED);
    }
}