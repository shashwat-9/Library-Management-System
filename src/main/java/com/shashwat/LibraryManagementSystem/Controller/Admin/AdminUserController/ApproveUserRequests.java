package com.shashwat.LibraryManagementSystem.Controller.Admin.AdminUserController;

import com.shashwat.LibraryManagementSystem.Service.Validators.UserValidator;
import com.shashwat.LibraryManagementSystem.Utils.Messages.Messages;
import com.shashwat.LibraryManagementSystem.Utils.Repo.RepoObj;
import com.shashwat.LibraryManagementSystem.models.Users.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApproveUserRequests {

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
