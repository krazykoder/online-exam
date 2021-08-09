package com.JPA.onlineExam.controllertest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JPA.onlineExam.modeltest.Book;
import com.JPA.onlineExam.repository.BookRepository;

@RestController
@RequestMapping(value = "/books", produces = { MediaType.APPLICATION_JSON_VALUE })
public class BookController {

	@Autowired
	private BookRepository bookrepo;

	public BookRepository getBookrepo() {
		return bookrepo;
	}

	public void setBookrepo(BookRepository bookrepo) {
		this.bookrepo = bookrepo;
	}

	@GetMapping(value = "/allbooks")
	public List<Book> getAllBooks() {

		return bookrepo.findAll();

	}

	@PostMapping(value = "/createbook")
	public Book createBook(@RequestBody Book b) {

		return bookrepo.save(b);

	}

}