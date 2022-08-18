package com.shashwat.LibraryManagementSystem.Controller.Admin.Add;

import com.shashwat.LibraryManagementSystem.POJOs.ReceivedAuthor;
import com.shashwat.LibraryManagementSystem.POJOs.ReceivedBook;
import com.shashwat.LibraryManagementSystem.Service.Validators.BookValidator;
import com.shashwat.LibraryManagementSystem.Utils.Create.CreateInstance;
import com.shashwat.LibraryManagementSystem.Utils.Messages.Messages;
import com.shashwat.LibraryManagementSystem.Utils.Repo.RepoObj;
import com.shashwat.LibraryManagementSystem.models.Books.BookCategory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class AddToInventory {

    @PostMapping("/admin/addBook")
    public HashMap<String, List<Integer>> addNewBook(@RequestBody List<ReceivedBook> book) {

        HashMap<String, List<Integer>> response = new HashMap<>();
        int isValid;

        for (int i = 0; i < book.size(); ++i) {
            isValid = BookValidator.bookValidator(book.get(i));
            if (isValid == 4) {
                RepoObj.bookRepository.save(CreateInstance.createBook(book.get(i)));
            }

            if (!response.containsKey(Messages.Book[isValid]))
                response.put(Messages.Book[isValid], new ArrayList<>());

            response.get(Messages.Book[isValid]).add(i);
        }

        return response;
    }

    @PostMapping("/admin/addBookCategory")
    public HashMap<String, List<Integer>> addBookCategory(@RequestBody List<String> bookCategoryList) {
        HashMap<String, List<Integer>> response = new HashMap<>();

        int isValid;
        for (int i = 0; i < bookCategoryList.size(); ++i) {
            isValid = BookValidator.bookCategoryValidator(bookCategoryList.get(i));
            if (isValid == 2) {
                RepoObj.bookCategoryRepository.save(new BookCategory(bookCategoryList.get(i)));
            }

            if (!response.containsKey(Messages.BookCategory[isValid])) {
                response.put(Messages.BookCategory[isValid], new ArrayList<>());
            }

            response.get(Messages.BookCategory[isValid]).add(i);
        }

        return response;
    }

    @PostMapping("/admin/addAuthor")
    public HashMap<String, List<Integer>> addAuthor(@RequestBody List<ReceivedAuthor> receivedAuthors) {

        HashMap<String, List<Integer>> response = new HashMap<>();

        int isValid;
        for (int i = 0; i < receivedAuthors.size(); ++i) {
            isValid = BookValidator.authorValidator(receivedAuthors.get(i));

            if (isValid == 2) {
                RepoObj.authorRepository.save(CreateInstance.createAuthor(receivedAuthors.get(i)));
            }

            if (!response.containsKey(Messages.Author[isValid])) {
                response.put(Messages.Author[isValid], new ArrayList<>());
            }

            response.get(Messages.Author[isValid]).add(i);
        }

        return response;
    }

}
