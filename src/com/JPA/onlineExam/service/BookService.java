package com.JPA.onlineExam.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JPA.onlineExam.modeltest.Book;
import com.JPA.onlineExam.repositorytest.BookRepository;

@Service("BookService")
public class BookService {

	@Autowired
	private BookRepository bookrepo;

	// @Test
	public void BookRun() {

		Book b = new Book("The Maificent");
		Book c = new Book("The Sun");
		Book d = new Book("The rainbow");

		List<Book> bl = new ArrayList<Book>();
		bl.add(b);
		bl.add(c);
		bl.add(d);

		BookRun(bl);
//		System.out.println(bookImpl.getBookById(3).toString());

		// System.out.println(bookImpl.getBookByTitle("The Sun").toString());

		// bookImpl.deleteBook(b);

	}

	public void BookRun(List<Book> bk) {

		for (Book b : bk) {
			bookrepo.save(b);
		}

	}

}
