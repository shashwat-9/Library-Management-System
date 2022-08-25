package com.shashwat.LibraryManagementSystem.Service.Validators;

import com.shashwat.LibraryManagementSystem.Service.Current;
import com.shashwat.LibraryManagementSystem.Utils.Repo.RepoObj;
import com.shashwat.LibraryManagementSystem.models.Books.Book;
import com.shashwat.LibraryManagementSystem.models.Users.IssueRequests;
import com.shashwat.LibraryManagementSystem.models.Users.User;

public class IssueValidator {

    public static String issue(int id) {

        Book book = RepoObj.bookRepository.findById(id);

        if (book == null) return "Book doesn't exists";

        if (book.getAvailableCopies() == 0) return "Not enough copies";

        //TO get the current User
        String username = Current.getCurrentUser();
        User user =  RepoObj.userRepository.findByUsername(username);

//        System.out.println(RepoObj.issueRequestRepository.countByUserAndIsApprovedIsFalse(user));
        if (RepoObj.issueRequestRepository.countByUserAndIsApprovedIsFalse(user) >= 2) {
            return "Request/issuance limit have exceeded";
        }

        IssueRequests issueRequest = new IssueRequests(user, book);

        RepoObj.issueRequestRepository.save(issueRequest);

        return "Request Added Successfully";
    }
}
