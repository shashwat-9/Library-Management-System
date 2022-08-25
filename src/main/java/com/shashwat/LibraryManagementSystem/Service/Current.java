package com.shashwat.LibraryManagementSystem.Service;

import com.shashwat.LibraryManagementSystem.Utils.Repo.RepoObj;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.Duration;
import java.time.LocalDateTime;

public class Current {

    public static String getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = null;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }

        return username;
    }

    public static double currentFine(int id) {
        LocalDateTime dateTime = LocalDateTime.now();
        LocalDateTime localDateTime = RepoObj.issueRequestRepository.findById(id).getSubmissionDate();

        long days = (Duration.between(dateTime, localDateTime).toHours() / 24);

        if (days <= 0)
            return 0.0;
        return days * 1.5;
    }
}
