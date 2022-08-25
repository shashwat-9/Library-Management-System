# Library-Management-System
Spring boot Backend Application for Library Management System

This project is swagger Enabled and thus the full documentation can be viewed by hitting http://localhost:8080/swagger-ui.html#/
after running the project.

# Three Roles in the system

  1. Head - Head of the Library
     
     Can disable/enable any Librarian and can perform the tasks of librarian as well.
     
     Can Issue Notice.
     
  2. Librarian - Looks after maintaining of the Library.
     Functions: 
          
          A. Adding Books, Bookcategories and Authors in the Database.
          
          B. Enabling/Disabling any user.
          
          C. Approving/Disapproving Issuance Requests.
          
          D. Submission of the issued book 

  3. User - User of the Library
  
  A user can have only two current requests.

# Endpoints

Note : All Parameters are request Parameters if not specified

# Public API(s):

  A. Account APIs
  
    1. /signUp
      
      POST API
      
      Description: To create an account. By default, user is disabled right after A/C creation.
                   An Admin can Enable the user upon verification.
      
      No Parameter
      
      JSON BODY : JSON
      role : 1 for User Account SignUp, 2 for Librarian Account SignUp
      {
        "username" : "<String>",
        "password" : "<String>",
        "role" : <Integer>, 
        "phone_no" : "<String>"
      }

  B. Query API
  
  Authors
  
    1. /allAuthor
  
       GET API
  
       Description : To get all authors in the database
       No Parameter
       
    2. /allAuthorByPage
       
       GET API
       
       Description : To get Authors in specified size of page
       Parameter: int page, int size
       
    3. /authorByTitle
    
       GET API
    
       Description : Finds all author containing the string in the parameter
       Parameter : String title
       
    4. /authorByCategory
    
       GET API
       
       Description : Finds all author that belongs to the specified bookCategory in parameter
       Parameter : int categoryId
       
  Books
  
    1. /searchBooks
    
       GET API

       Description:  Finds all book by the specified title and searchBy option
       Parameters: String title, int choice
       
       choice :- 1 for Book title, 2 for author name, 3 for bookCategory
       title is the corresponding keyword
       
       Return : List of Books belonging to the choosed Search Category and title
       
    
    2. /searchAllBooks
      
       GET API
       
       Description : Finds all the books in pages of specified sizes
       Parameters: int page, int size
       
    3. /allBookCategory
    
        GET API
        
        Description : Finds all the book Category
        No Parameter
       

# Admin API(s):
    APIs accessible through authentication credentials of an admin
    
    All APIs in this Category has the format /admin/**
    
  1. /admin/addBookCategory
    
    POST API
    
    Description : To add a List of Book Category
    No Parameter
    
    JSON BODY: List<String>
    
    Return : A HashMap<String, List<Integer>> , where key is the status of Addition and List of Integer is the corresponding
            books to that status.
            
  2. /admin/addAuthor
    
    POST API
    
    Description : To add a List of Authors
    No Parameter
    
    JSON BODY : List<ReceivedAuthor>
    
    ReceivedAuthor JSON format :
    {
      "title" : <String>,
      "bookCategory" : <int> (Id of the category)
    }
    
    Return :  A HashMap<String, List<Integer>> , where key is the status of Addition and List of Integer is the corresponding
            books to that status.
            
  3. /admin/addBook
  
    POST API
    
    Description: To add a List of Books
    No Parameter
    
    JSON BODY : List<ReceivedBook>
    
    ReceivedBook JSON Format :
    {
        "title" : <String>,
        "totalCopies" : <int>,
        "edition" : <String>,
        "bookCategoryId" : <int>,
        "authorList" : List<Integer>
    }
    
  4. /admin/approveIssue
  
  Patch API
  
  Description: approve Issue Request
  Parameter : id of the IssueRequest
  
  5. /admin/approveSubmission
  
  Patch API
  
  Description: approve Submission request of a book by a user.
  Parameter : id of the Issue Request
  
  6. /admin/calculateFine
  
  Get API
  
  Description: Calculate current fine for a given issuance of book
  Parameter : id of the Issue Request
  
  7. /admin/disApproveRequest
  
  Delete API
  
  Description: used to delete an issue request entry from the database.
  Parameter : id of the issue request.
  
# User APIs

  1. /user/issueBook
  
  Description : To add an issue Request
  Parameter : id of the book to generate Request for.
  
  2. /user/issueDetails
  
  Description : To get the details of all the issue request made by a user.
  No Paramater
