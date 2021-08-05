package com.JPA.onlineExam.repoTest;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;

@Stateless
public class BookRun {

	@Inject
	BookRepositoryImpl bookImpl;

	@Test
	@Transactional
	public void BookRun() {

//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Online_Exam");
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();

		Book b = new Book("The Magnificent");
		Book c = new Book("The Sun");
		Book d = new Book("The rainbow");
//
//		BookRepositoryImpl bookImpl = new BookRepositoryImpl();
//
		bookImpl.saveBook(b);
		bookImpl.saveBook(c);
		bookImpl.saveBook(d);
//
//		System.out.println(bookImpl.getBookById(2).toString());

		// bookImpl.getBookByTitle("The Sun");

//		em.getTransaction().commit();

//		em.close();
//		emf.close();

		System.out.println("Just a test");
	}

}
