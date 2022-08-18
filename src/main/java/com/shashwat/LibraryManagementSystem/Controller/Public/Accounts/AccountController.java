package com.shashwat.LibraryManagementSystem.Controller.Public.Accounts;

import com.shashwat.LibraryManagementSystem.POJOs.CreateUserRequest;
import com.shashwat.LibraryManagementSystem.Service.Validators.BookValidator;
import com.shashwat.LibraryManagementSystem.Utils.Create.CreateInstance;
import com.shashwat.LibraryManagementSystem.Utils.Messages.Messages;
import com.shashwat.LibraryManagementSystem.Utils.Repo.RepoObj;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

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
