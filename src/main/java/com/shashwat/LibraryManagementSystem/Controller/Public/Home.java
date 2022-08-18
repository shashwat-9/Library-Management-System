package com.shashwat.LibraryManagementSystem.Controller.Public;

import com.shashwat.LibraryManagementSystem.Utils.Repo.RepoObj;
import com.shashwat.LibraryManagementSystem.models.Admin.Notification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
public class Home {

    /**
     * Basic welcome API
     * */
    @GetMapping("/welcome")
    public String welcome() {

        String welcome = "WELCOME TO CENTRAL LIBRARY";
        welcome += "Head to : https://github.com/shashwat-9/Library-Management-System";
        welcome += "for Repo documentation and Read.md file";
        return welcome;
    }


    /**
     * Api used for fetching notifications sorted Date-Wise
     * */
    @GetMapping("/notifications")
    public Page<Notification>  getNotifications(@RequestParam int size,@RequestParam int page) {
        Sort sort = Sort.by("Date").descending();
        return RepoObj.notificationRepository.findAll(PageRequest.of(page, size, sort));
    }

}