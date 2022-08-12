package com.shashwat.LibraryManagementSystem.Service.Validators;

import com.shashwat.LibraryManagementSystem.POJOs.CreateUserRequest;
import com.shashwat.LibraryManagementSystem.POJOs.ReceivedAuthor;
import com.shashwat.LibraryManagementSystem.POJOs.ReceivedBook;
import com.shashwat.LibraryManagementSystem.Utils.Repo.RepoObj;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookValidator {


    public static int userValidator(CreateUserRequest createUserRequest) {
        String username = createUserRequest.getUsername();
        String password = createUserRequest.getPassword();
        int role = createUserRequest.getRole();
        String phoneNo = createUserRequest.getPhone_no();

        if (username == null || password == null || phoneNo == null)
            return 1;

        if (role != 1 && role != 2)
            return 2;

        if (RepoObj.userRepository.findByPhoneNo(phoneNo) != null)
            return 0;

        if (phoneNo.length() != 10)
            return 3;

        if (username.length() < 8 || username.length() > 15)
            return 5;

        if (password.length() < 8 || password.length() > 15)
            return 6;


        return 4;
    }

    public static int bookValidator(ReceivedBook book) {
        String title = book.getTitle();
        int totalCopies = book.getTotalCopies();
        int bookCategoryId = book.getBookCategoryId();
        List<Integer> authorList= book.getAuthorList();

        if (title == null)
            return 0;

        if (totalCopies < 0)
            return 1;

        if (!RepoObj.bookCategoryRepository.existsById(bookCategoryId))
            return 2;

        for (Integer integer : authorList) {
            if (!RepoObj.authorRepository.existsById(integer))
                return 3;
        }

        return 4;
    }

    public static int bookCategoryValidator(String title) {

        if (title == null)
            return 0;

        if (RepoObj.bookCategoryRepository.existsByTitleIgnoreCase(title))
            return 1;

        return 2;
    }

    public static int authorValidator(ReceivedAuthor receivedAuthor) {
        String title= receivedAuthor.getTitle();
        int bookCategoryId =receivedAuthor.getBookCategory();

        if (title == null)
            return 0;

        if (!RepoObj.bookCategoryRepository.existsById(bookCategoryId))
            return 1;

        return 2;
    }

}
