package com.shashwat.LibraryManagementSystem.Utils.Validators;

import com.shashwat.LibraryManagementSystem.POJOs.CreateUserRequest;
import com.shashwat.LibraryManagementSystem.POJOs.ReceivedBook;
import com.shashwat.LibraryManagementSystem.Utils.Messages.Messages;
import com.shashwat.LibraryManagementSystem.Utils.Repo.RepoObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Validator {

    private static RepoObj repoObj;

    @Autowired
    Validator(RepoObj repoObj) {
        Validator.repoObj = repoObj;
    }

    public static int userValidator(CreateUserRequest createUserRequest) {
        String username = createUserRequest.getUsername();
        String password = createUserRequest.getPassword();
        int role = createUserRequest.getRole();
        String phone_no = createUserRequest.getPhone_no();

        if (username == null || password == null || phone_no == null)
            return 1;

        if (role != 1 && role != 2)
            return 2;

        if (repoObj.userRepository.findByPhoneNo(phone_no) != null)
            return 0;

        if (phone_no.length() != 10)
            return 3;

        if (username.length() < 8 || username.length() > 15)
            return 5;

        if (password.length() < 8 || password.length() > 15)
            return 6;

        return 4;
    }

    public static int bookValidator(ReceivedBook book) {
        String title = book.getTitle();
        String edition = book.getEdition();
        int totalCopies = book.getTotalCopies();
        int bookCategoryId = book.getBookCategoryId();
        List<Integer> authorList= book.getAuthorList();

        if (title == null)
            return 1;

        if (totalCopies < 0)
            return 2;

        if (!repoObj.bookCategoryRepository.existsById(bookCategoryId))
            return 3;



        return 0;
    }

}
