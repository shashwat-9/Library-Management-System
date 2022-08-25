package com.shashwat.LibraryManagementSystem.Controller.User;

import com.shashwat.LibraryManagementSystem.Service.Current;
import com.shashwat.LibraryManagementSystem.Service.Validators.IssueValidator;
import com.shashwat.LibraryManagementSystem.Utils.Repo.RepoObj;
import com.shashwat.LibraryManagementSystem.models.Users.IssueRequests;
import com.shashwat.LibraryManagementSystem.models.Users.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRequests {

    @PostMapping("/user/issueBook")
    public String issueBook(@RequestParam int id) {
        return IssueValidator.issue(id);
    }

    @GetMapping("/user/issueDetails")
    public List<IssueRequests> details() {

        String username = Current.getCurrentUser();
        User user = RepoObj.userRepository.findByUsername(username);
        return RepoObj.issueRequestRepository.findByUser(user);

    }
}
