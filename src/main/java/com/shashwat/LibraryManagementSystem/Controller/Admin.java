package com.shashwat.LibraryManagementSystem.Controller;

import com.shashwat.LibraryManagementSystem.POJOs.AddNotification;
import com.shashwat.LibraryManagementSystem.POJOs.ReceivedAuthor;
import com.shashwat.LibraryManagementSystem.POJOs.ReceivedBook;
import com.shashwat.LibraryManagementSystem.Service.Validators.UserValidator;
import com.shashwat.LibraryManagementSystem.Utils.Create.CreateInstance;
import com.shashwat.LibraryManagementSystem.Utils.Messages.Messages;
import com.shashwat.LibraryManagementSystem.Utils.Repo.RepoObj;
import com.shashwat.LibraryManagementSystem.Service.Validators.BookValidator;
import com.shashwat.LibraryManagementSystem.models.Books.BookCategory;
import com.shashwat.LibraryManagementSystem.models.Users.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class Admin {

    @PostMapping("/admin/addNewBook")
    public HashMap<String, List<Integer>> addNewBook(@RequestBody List<ReceivedBook> book) {

        HashMap<String, List<Integer>> response = new HashMap<>();
        int isValid;

        for (int i = 0; i < Messages.Book.length; ++i)
            response.put(Messages.Book[i], new ArrayList<>());

        for (int i = 0; i < book.size(); ++i) {
            isValid = BookValidator.bookValidator(book.get(i));
            if (isValid == 4) {
                RepoObj.bookRepository.save(CreateInstance.createBook(book.get(i)));
            }

            response.get(Messages.Book[isValid]).add(i);
        }

        return response;
    }

    @PostMapping("/admin/addBookCategory")
    public HashMap<String, List<Integer>> addBookCategory(@RequestBody List<String> bookCategoryList) {
        HashMap<String, List<Integer>> response = new HashMap<>();

        for (int i = 0; i < Messages.BookCategory.length; ++i)
            response.put(Messages.BookCategory[i], new ArrayList<>());

        int isValid;
        for (int i = 0; i < bookCategoryList.size(); ++i) {
            isValid = BookValidator.bookCategoryValidator(bookCategoryList.get(i));
            if (isValid == 2) {
                RepoObj.bookCategoryRepository.save(new BookCategory(bookCategoryList.get(i)));
            }

            response.get(Messages.BookCategory[isValid]).add(i);
        }

        return response;
    }

    @PostMapping("/admin/addAuthor")
    public HashMap<String, List<Integer>> addAuthor(@RequestBody List<ReceivedAuthor> receivedAuthors) {

        HashMap<String, List<Integer>> response = new HashMap<>();
        for (int i = 0; i < Messages.Author.length; ++i)
            response.put(Messages.Author[i], new ArrayList<>());

        int isValid;
        for (int i = 0; i < receivedAuthors.size(); ++i) {
           isValid = BookValidator.authorValidator(receivedAuthors.get(i));

            if (isValid == 2) {
                RepoObj.authorRepository.save(CreateInstance.createAuthor(receivedAuthors.get(i)));
           }

           response.get(Messages.Author[isValid]).add(i);
        }

        return response;
    }

    @PostMapping("/admin/addNotice")
    public void addNotice(@RequestBody AddNotification addNotification) {
    }

    @GetMapping("/admin/allUsers")
    public Page<User> getAllUsers(@RequestParam int size,@RequestParam int page) {
        return RepoObj.userRepository.findAll(PageRequest.of(page, size));
    }

    @GetMapping("/admin/allEnabledUsers")
    public Page<User> getAllEnabledUser(@RequestParam int size,@RequestParam int page) {
        return RepoObj.userRepository.findUserByEnabled(PageRequest.of(page, size), true);
    }

    @GetMapping("/admin/allDisabledUsers")
    public Page<User> getAllDisabledUsers (@RequestParam int size,@RequestParam int page) {
        return RepoObj.userRepository.findUserByEnabled(PageRequest.of(page, size), false);
    }

    @PutMapping("/admin/enableUser")
    public String enableUser(@RequestParam String phoneNo) {

        int isValid = UserValidator.validateAndEnableUser(phoneNo);
        return Messages.UserStatus[isValid];
    }

    @PutMapping("/admin/disableUser")
    public String disableUser(@RequestParam String phoneNo) {

        int isValid = UserValidator.validateAndDisableUSer(phoneNo);

        return Messages.UserStatus[isValid];
    }

}
