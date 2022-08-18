package com.shashwat.LibraryManagementSystem.Utils.Messages;

public class Messages {

    public static String[] UserSignUp = {
            "User Already Exits",
            "Null Fields not allowed",
            "Role is invalid",
            "Invalid Phone no.",
            "Successfully Created, Wait for Approval",
            "Username length should be between 8 and 15 characters",
            "Password length should be between 8 and 15 characters",
            "Username already exists"
    };

    public static String[] Book = {
            "Book title can't be Null",
            "Total Copies can't -ve",
            "BookCategory doesn't exists",
            "Author doesn't exists",
            "Book Added Successfully"
    };

    public static String[] BookCategory = {
            "Null Values not allowed",
            "Category Already Exists",
            "Category added Successfully"
    };

    public static String[] Author = {
            "Author title can't be null",
            "BookCategory doesn't exists",
            "Author successfully created"
    };

    public static String[] UserStatus = {
        "User doesn't exists",
        "User is already enabled",
        "User is enabled",
        "User is already disabled",
        "User is disabled"
    };
}
