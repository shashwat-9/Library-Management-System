package com.shashwat.LibraryManagementSystem.models.Users;

import com.shashwat.LibraryManagementSystem.models.Books.Book;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class IssueRequests {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Book book;

    private LocalDateTime requestedDate;

    private LocalDateTime submittedOn;

    private LocalDateTime approvedOn;

    private LocalDateTime submissionDate;

    private double fineCollected;
    private boolean isApproved;

    public IssueRequests() {
        submissionDate = null;
        submittedOn = null;
        approvedOn = null;
        fineCollected = 0;
        isApproved = false;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public IssueRequests(User user, Book book) {
        this();
        this.user = user;
        this.book = book;
        this.requestedDate = LocalDateTime.now();
    }

    public double getFineCollected() {
        return fineCollected;
    }

    public LocalDateTime getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(LocalDateTime submissionDate) {
        this.submissionDate = submissionDate;
    }

    public void setFineCollected(int fineCollected) {
        this.fineCollected = fineCollected;
    }

    public LocalDateTime getRequestedDate() {
        return requestedDate;
    }

    public void setRequestedDate(LocalDateTime requestedDate) {
        this.requestedDate = requestedDate;
    }

    public LocalDateTime getSubmittedOn() {
        return submittedOn;
    }

    public void setSubmittedOn(LocalDateTime submittedOn) {
        this.submittedOn = submittedOn;
    }

    public LocalDateTime getApprovedOn() {
        return approvedOn;
    }

    public void setApprovedOn(LocalDateTime approvedOn) {
        this.approvedOn = approvedOn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

//    public LocalDateTime getRequestedDate() {
//        return requestedDate;
//    }
//
//    public void setRequestedDate(LocalDateTime date) {
//        this.requestedDate = date;
//    }
}
