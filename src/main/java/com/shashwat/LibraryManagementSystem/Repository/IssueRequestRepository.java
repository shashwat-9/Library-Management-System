package com.shashwat.LibraryManagementSystem.Repository;

import com.shashwat.LibraryManagementSystem.models.Users.IssueRequests;
import com.shashwat.LibraryManagementSystem.models.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

public interface IssueRequestRepository extends JpaRepository<IssueRequests, Integer> {

    IssueRequests findById(int id);
    List<IssueRequests> findByUser(User user);

    int countByUserAndIsApprovedIsFalse(User user);

    @Transactional
    @Modifying
    @Query("update IssueRequests req set req.isApproved=:val where req.id=:id")
    void approve(int id, boolean val);

    @Transactional
    @Modifying
    @Query("update IssueRequests req set req.approvedOn =:dateTime where req.id =:id")
    public void addApprovedDate(@Param("id") int id, @Param("dateTime") LocalDateTime dateTime);

    @Transactional
    @Modifying
    @Query("update IssueRequests req set req.submissionDate =:dateTime where req.id =:id")
    public void addSubmissionDate(@Param("id") int id,@Param("dateTime") LocalDateTime dateTime);

    @Transactional
    @Modifying
    @Query("update IssueRequests req set req.fineCollected =:fine where req.id =:id")
    public void addFinalFineCollected(int id, double fine);

    @Transactional
    @Modifying
    @Query("update IssueRequests req set req.submittedOn =:localDateTime where req.id =:id")
    public void addSubmittedOn(int id, LocalDateTime localDateTime);
}
