package com.JPA.onlineExam.repoTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.JPA.onlineExam.modeltest.Book;

public class bookTest_emf {

	@Test
	public void BookRun() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Online_Exam");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Book b = new Book("The Magnificent");
		Book c = new Book("The Sun");
		Book d = new Book("The rainbow");

		BookRepositoryImpl bookImpl = new BookRepositoryImpl(em);

		bookImpl.saveBook(b);
		bookImpl.saveBook(c);
		bookImpl.saveBook(d);

		System.out.println(bookImpl.getBookById(3).toString());

		// System.out.println(bookImpl.getBookByTitle("The Sun").toString());

		bookImpl.deleteBook(b);

		em.getTransaction().commit();

		em.close();
		emf.close();

	}

}
