# Library-Management-System
Spring boot Backend Application for Library Management System

# Three Roles in the system

  1. Head - Head of the Library
  2. Librarian - Looks after maintaining of the Library.
     Functions: 
          A. Adding Books, Bookcategories and Authors in the Database.
          B. Enabling/Disabling any user.
          C. Issue Notice.
  3. User - User of the Library


# Public API(s):

  1. /signUp
    
    Description: Post API, to create an account. By default, user is disabled right after A/C creation.
                 An Admin can Enable the user upon verification.
    
    Parameter: JSON
    role : 1 for User Account SignUp, 2 for Librarian Account SignUp
    {
      "username" : "<String>",
      "password" : "<String>",
      "role" : <Integer>, 
      "phone_no" : "<String>"
    }
