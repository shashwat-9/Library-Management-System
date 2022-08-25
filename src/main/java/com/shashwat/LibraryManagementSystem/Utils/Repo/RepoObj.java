package com.shashwat.LibraryManagementSystem.Utils.Repo;

import com.shashwat.LibraryManagementSystem.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Contains Instances of all the Repositories
 * */
@Component
public class RepoObj {

    public static AuthorRepository authorRepository;
    public static BookCategoryRepository bookCategoryRepository;
    public static BookRepository bookRepository;
    public static NotificationRepository notificationRepository;
    public static UserRepository userRepository;

    public static IssueRequestRepository issueRequestRepository;

    @Autowired
    public void setIssueRequestRepository(IssueRequestRepository requestRepository) {
        RepoObj.issueRequestRepository = requestRepository;
    }

    @Autowired
    public void setAuthorRepository(AuthorRepository authorRepository) {
        RepoObj.authorRepository = authorRepository;
    }

    @Autowired
    public void setBookCategoryRepository(BookCategoryRepository bookCategoryRepository) {
        RepoObj.bookCategoryRepository = bookCategoryRepository;
    }

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        RepoObj.bookRepository = bookRepository;
    }

    @Autowired
    public void setNotificationRepository(NotificationRepository notificationRepository) {
        RepoObj.notificationRepository = notificationRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        RepoObj.userRepository = userRepository;
    }
}
