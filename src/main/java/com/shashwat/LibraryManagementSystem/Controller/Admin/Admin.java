package com.shashwat.LibraryManagementSystem.Controller.Admin;

import com.shashwat.LibraryManagementSystem.POJOs.AddNotification;
import org.springframework.web.bind.annotation.*;

@RestController
public class Admin {

    @PostMapping("/admin/addNotice")
    public void addNotice(@RequestBody AddNotification addNotification) {
    }


}
