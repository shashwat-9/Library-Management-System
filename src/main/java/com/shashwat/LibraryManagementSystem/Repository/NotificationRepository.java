package com.shashwat.LibraryManagementSystem.Repository;

import com.shashwat.LibraryManagementSystem.models.Admin.Notification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NotificationRepository extends JpaRepository<Notification, Integer> {
    Page<Notification> findAllByOrderByDate(Pageable pageable);

}
