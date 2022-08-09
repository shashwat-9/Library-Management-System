package com.shashwat.LibraryManagementSystem.POJOs;

/*
* integer for roles
* 1 -> for User
* 2 -> for Librarian
* 3 -> Head
* */
public class CreateUserRequest {
    private String username;
    private String password;
    private int role;
    private String phone_no;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getRole() {
        return role;
    }

    public String getPhone_no() {
        return phone_no;
    }
}
