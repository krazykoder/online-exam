package com.JPA.onlineExam.repoTest;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

@Named
public class BookRepositoryImpl implements BookInterface {

	@PersistenceContext(unitName = "JPA_Online_Exam", type = PersistenceContextType.EXTENDED)
	private EntityManager em;

//	public BookRepositoryImpl(EntityManager em) {
//		this.em = em;
//	}

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
		if (b.getId() == null) {
			em.persist(b);
		} else {
			em.merge(b);
		}

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
