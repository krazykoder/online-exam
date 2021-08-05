package com.JPA.onlineExam.repoTest;

import java.util.List;

public interface BookInterface {

	// Book getBookById(Long id);

	List<Book> getBookByTitle(String title);

	Book saveBook(Book b);

	Book getBookById(int i);

	void deleteBook(Book b);

}
