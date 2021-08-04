package com.JPA.onlineExam.repoTest;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named
public class BookRepository implements GenericRepository<Book, Integer> {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Book find(Integer id) {
		return em.find(Book.class, id);
	}

	@Override
	public List<Book> findAll() {
		return em.createQuery("select p from Book p", Book.class).getResultList();
	}

	@Override
	public void save(Book entity) {
		em.persist(entity);
		em.flush();
	}

	@Override
	public void update(Book entity) {
		if (find(entity.getId()) == null) {
			save(entity);
			return;
		}
		em.flush();
	}

	@Override
	public void delete(Book entity) {
		em.remove(entity);
		em.flush();
	}
}
