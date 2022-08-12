package com.shashwat.LibraryManagementSystem.Utils.Create;

import com.shashwat.LibraryManagementSystem.POJOs.CreateUserRequest;
import com.shashwat.LibraryManagementSystem.POJOs.ReceivedAuthor;
import com.shashwat.LibraryManagementSystem.POJOs.ReceivedBook;
import com.shashwat.LibraryManagementSystem.Utils.Repo.RepoObj;
import com.shashwat.LibraryManagementSystem.models.Books.Author;
import com.shashwat.LibraryManagementSystem.models.Books.Book;
import com.shashwat.LibraryManagementSystem.models.Books.BookCategory;
import com.shashwat.LibraryManagementSystem.models.Users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class CreateInstance {

    public static User createUser(CreateUserRequest createUserRequest) {
        String username = createUserRequest.getUsername();
        String password = createUserRequest.getPassword();
        String phoneNo = createUserRequest.getPhone_no();
        int role = createUserRequest.getRole();

        String authorities = null;

        if (role == 1) {
            authorities = "User";
        }   else if (role == 2) {
            authorities = "Librarian:User";
        }

        return new User(phoneNo, username, password, authorities);
    }

    public static Book createBook(ReceivedBook receivedBook) {
        String title = receivedBook.getTitle();
        int totalCopies = receivedBook.getTotalCopies();
        String edition = receivedBook.getEdition();
        List<Integer> authorList= receivedBook.getAuthorList();
        int bookCategoryId= receivedBook.getBookCategoryId();

        BookCategory bookCategory = RepoObj.bookCategoryRepository.findById(bookCategoryId);

        Set<Author> authorSet = new HashSet<>();

        for (int i : authorList) {
            authorSet.add(RepoObj.authorRepository.findById(i));
        }

        return new Book(title,edition, totalCopies, totalCopies, bookCategory, authorSet);

    }

    public static Author createAuthor(ReceivedAuthor receivedAuthor) {
        int categoryId = receivedAuthor.getBookCategory();
        BookCategory bookCategory = RepoObj.bookCategoryRepository.findById(categoryId);
        return new Author(receivedAuthor.getTitle(), bookCategory);
    }

}
