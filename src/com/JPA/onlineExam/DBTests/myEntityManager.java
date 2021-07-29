package com.JPA.onlineExam.DBTests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class myEntityManager {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Online_Exam");
	EntityManager em = emf.createEntityManager();

	public EntityManager getentitymanager() {
		return em;
	}

	public void closeAll() {
		em.close();
		emf.close();
	}

}