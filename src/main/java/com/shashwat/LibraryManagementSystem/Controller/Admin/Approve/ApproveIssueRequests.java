package com.shashwat.LibraryManagementSystem.Controller.Admin.Approve;

import com.shashwat.LibraryManagementSystem.Service.Current;
import com.shashwat.LibraryManagementSystem.Utils.Repo.RepoObj;
import com.shashwat.LibraryManagementSystem.models.Books.Book;
import com.shashwat.LibraryManagementSystem.models.Users.IssueRequests;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class ApproveIssueRequests {

    @PatchMapping("/admin/approveIssue")
    public void approveRequest(int id) {

        RepoObj.issueRequestRepository.addApprovedDate(id, LocalDateTime.now());
        RepoObj.issueRequestRepository.approve(id, true);
        RepoObj.issueRequestRepository.addSubmissionDate(id, LocalDateTime.now().plusDays(10));

        Book book = RepoObj.issueRequestRepository.findById(id).getBook();

        RepoObj.bookRepository.changeAvailableCopies(book.getId(), book.getAvailableCopies() - 1);
    }

    @PatchMapping("/admin/approveSubmission")
    public String approveSubmission(int id) {
        Book book = RepoObj.issueRequestRepository.findById(id).getBook();
        IssueRequests issueRequests= RepoObj.issueRequestRepository.findById(id);

        if (issueRequests.getSubmittedOn() != null) {
            return "book already Submitted";
        }
        RepoObj.issueRequestRepository.addFinalFineCollected(id, Current.currentFine(id));
        RepoObj.issueRequestRepository.addSubmittedOn(id, LocalDateTime.now());
        RepoObj.bookRepository.changeAvailableCopies(book.getId(), book.getAvailableCopies() + 1);

        return "Book submitted";
    }

    @GetMapping("/admin/calculateFine")
    public double calculateFine(int id) {
        return Current.currentFine(id);
    }

    @DeleteMapping("/admin/disApproveRequest")
    public String disapprove(int id) {
        IssueRequests issueRequests = RepoObj.issueRequestRepository.findById(id);
        if (issueRequests == null) {
            return "Entry doesn't exists";
        }

        RepoObj.issueRequestRepository.deleteById(id);

        return "Entry successfully deleted";
    }

}
