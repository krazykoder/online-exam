package com.JPA.onlineExam.repoTest;

import javax.persistence.EntityManager;

public class BookRepositoryImpl implements BookInterface {

	private EntityManager em;

	public BookRepositoryImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public Book getBookById(int i) {
		return em.find(Book.class, i);
	}

//	@Override

	// public Book getBookByTitle(String title) {
//		TypedQuery<Book> q = em.createQuery("SELECT bookName FROM Book  WHERE bookName = :title", Book.class);
//		q.setParameter("title", title);
//		return q.getSingleResult();
// }	

	@Override
	public Book saveBook(Book b) {
//		if (b.getId() == null) {
//			em.persist(b);
//		} else {
		b = em.merge(b);
//		}

		return b;
	}

//	@Override
//	public void deleteBook(Book b) {
//		if (em.contains(b)) {
//			em.remove(b);
//		} else {
//			em.merge(b);
//		}
//	}
}
