package com.shashwat.LibraryManagementSystem.Utils.CreateInstance;

import com.shashwat.LibraryManagementSystem.POJOs.CreateUserRequest;
import com.shashwat.LibraryManagementSystem.models.Users.User;

public class Create {

    public static User createUser(CreateUserRequest createUserRequest) {
        String username = createUserRequest.getUsername();
        String password = createUserRequest.getPassword();
        String phoneNo = createUserRequest.getPhone_no();
        int role = createUserRequest.getRole();

        String authorities = null;

        if (role == 1) {
            authorities = "User";
        }   else if (role == 2) {
            authorities = "Librarian";
        }   else if (role == 3) {
            authorities = "Head";
        }

        return new User(phoneNo, username, password, authorities);
    }
}
