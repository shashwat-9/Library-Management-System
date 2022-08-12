package com.shashwat.LibraryManagementSystem.Service.Validators;

import com.shashwat.LibraryManagementSystem.Utils.Repo.RepoObj;
import com.shashwat.LibraryManagementSystem.models.Users.User;

public class UserValidator {

    /**
     * Return Integer values mark the
     * index of the array in Messages Class
     **/

    public static int validateAndEnableUser(String phoneNo) {

        User user = RepoObj.userRepository.findByPhoneNoAndAuthoritiesNotContaining(phoneNo, "Librarian");
//        System.out.println(user);
        if (user == null)
            return 0;

        if (user.isEnabled()) {
            return 1;
        }

        RepoObj.userRepository.updateEnableToTrue(true, phoneNo);

        return 2;
    }

    public static int validateAndDisableUSer(String phoneNo) {

        User user = RepoObj.userRepository.findByPhoneNoAndAuthoritiesNotContaining(phoneNo, "Librarian");
        if (user == null) {
            return 0;
        }   else if (!user.isEnabled()) {
            return 3;
        }

        RepoObj.userRepository.updateEnableToTrue(false, phoneNo);

        return 4;
    }

}
