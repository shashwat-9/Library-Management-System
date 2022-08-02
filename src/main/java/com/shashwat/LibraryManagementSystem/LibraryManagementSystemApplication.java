package com.shashwat.LibraryManagementSystem;

import com.shashwat.LibraryManagementSystem.Repository.AuthorRepository;
import com.shashwat.LibraryManagementSystem.Repository.BookCategoryRepository;
import com.shashwat.LibraryManagementSystem.Repository.BookRepository;
import com.shashwat.LibraryManagementSystem.models.Books.Author;
import com.shashwat.LibraryManagementSystem.models.Books.Book;
import com.shashwat.LibraryManagementSystem.models.Books.BookCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//@EnableSwagger2
@SpringBootApplication
public class LibraryManagementSystemApplication implements CommandLineRunner {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private BookCategoryRepository bookCategoryRepository;

	@Autowired
	private AuthorRepository authorRepository;

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		BookCategory bookCategory1 = new BookCategory("Physics");
		BookCategory bookCategory2 = new BookCategory("Algorithms");
		BookCategory bookCategory3 = new BookCategory("Economics");
		BookCategory bookCategory4 = new BookCategory("Warfare");

		List<BookCategory> bookCategoryList = new ArrayList<>();
		bookCategoryList.add(bookCategory1);
		bookCategoryList.add(bookCategory2);
		bookCategoryList.add(bookCategory3);
		bookCategoryList.add(bookCategory4);

		bookCategoryRepository.saveAll(bookCategoryList);

		Author author1 = new Author("H C Verma", bookCategory1);
		Author author2 = new Author("Thomas H Cormen", bookCategory2);
		Author author3 = new Author("Resnick", bookCategory1);
		Author author4 = new Author("Shashwat Mishra", bookCategory4);
		Author author5 = new Author("Steven D. Levitt", bookCategory3);
		Author author6 = new Author("Halliday", bookCategory1);

		List<Author> authorList = new ArrayList<>();
		authorList.add(author1);
		authorList.add(author2);
		authorList.add(author3);
		authorList.add(author4);
		authorList.add(author5);
		authorList.add(author6);
		authorRepository.saveAll(authorList);

		Set<Author> l1 = new HashSet<>();
		l1.add(author1);
		Set<Author> l2 = new HashSet<>();
		l2.add(author3);
		l2.add(author6);
		Set<Author> l3 = new HashSet<>();
		l3.add(author5);
		Set<Author> l4 = new HashSet<>();
		l4.add(author4);
		Set<Author> l5 = new HashSet<>();
		l5.add(author2);

		Book b1 = new Book("Concepts of Physics", "1.0", 5, 5, bookCategory1, l1);
		Book b2 = new Book("Fundamentals of physics", "2.0", 5, 5, bookCategory1, l2);
		Book b3 = new Book("Frekonomics", "1.0", 6, 6, bookCategory3, l3);
		Book b4 = new Book("Strategic Warfare", "1.0", 2, 2, bookCategory4, l4);
		Book b5 = new Book("Intoduction to algorithms", "1.0", 6, 6, bookCategory2,l5);
		List<Book> bookList = new ArrayList<>();

		bookList.add(b1);
		bookList.add(b2);
		bookList.add(b3);
		bookList.add(b4);
		bookList.add(b5);

		bookRepository.saveAll(bookList);

	}
}
