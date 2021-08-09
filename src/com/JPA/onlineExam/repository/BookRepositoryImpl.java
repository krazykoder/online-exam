package com.JPA.onlineExam.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.JPA.onlineExam.modeltest.Book;

public class BookRepositoryImpl {

	private EntityManager em;

	public BookRepositoryImpl(EntityManager em) {
		this.em = em;
	}

	public Book getBookById(long i) {
		return em.find(Book.class, i);
	}

	public List<Book> getBookByTitle(String title) {
//		TypedQuery<Book> q = em.createQuery("SELECT bookName FROM Book  WHERE bookName = :title", Book.class);
//		q.setParameter("title", title);
//		return q.getSingleResult();

		Query query = em.createQuery("from Book WHERE bookName=" + title);
		List<Book> results = query.getResultList();

		return results;

	}

	public Book saveBook(Book b) {
//		if (b.getId() == null) {
//			em.persist(b);
//		} else {
		b = em.merge(b);
//		}

		return b;
	}

	public void deleteBook(Book b) {
		if (em.contains(b)) {
			em.remove(b);
		} // else {
//			em.merge(b);
//		}
	}
}
