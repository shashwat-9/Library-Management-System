package com.shashwat.LibraryManagementSystem.Utils.Repo;

import com.shashwat.LibraryManagementSystem.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Contains Instances of all the Repositories
 * */
@Component
public class RepoObj {

    public AuthorRepository authorRepository;
    public BookCategoryRepository bookCategoryRepository;
    public BookRepository bookRepository;
    public NotificationRepository notificationRepository;
    public UserRepository userRepository;

    @Autowired
    public void setAuthorRepository(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Autowired
    public void setBookCategoryRepository(BookCategoryRepository bookCategoryRepository) {
        this.bookCategoryRepository = bookCategoryRepository;
    }

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Autowired
    public void setNotificationRepository(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
