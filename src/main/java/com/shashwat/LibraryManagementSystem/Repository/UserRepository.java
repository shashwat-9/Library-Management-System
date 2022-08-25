package com.shashwat.LibraryManagementSystem.Repository;

import com.shashwat.LibraryManagementSystem.models.Users.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import javax.transaction.Transactional;

public interface UserRepository extends JpaRepository<User, String> {

    User findByPhoneNo(String phone);

    User findByPhoneNoAndAuthoritiesNotContaining(String phoneNo, String role);

    User findByUsername(String username);

    @Query("select u from User u where u.isEnabled = :val")
    Page<User> findUserByEnabled(Pageable pageable, @Param("val") boolean val);

    @Transactional
    @Modifying
    @Query("update User user set user.isEnabled =:enable where user.phoneNo=:phone")
    void updateEnableToTrue(@Param("enable") boolean enable, @Param("phone") String phone);

}