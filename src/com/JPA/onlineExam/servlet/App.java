package com.JPA.onlineExam.servlet;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.JPA.online.old.MyTest;
import com.JPA.onlineExam.entity.Question;

// This is an initial version of the App

public class App {

	@Test
	public void Test_Question_App() {

		Question question1 = new Question();
		question1.setQid(101);
		question1.setQuestion("What is java ?");

		Question question2 = new Question();
		question2.setQid(102);
		question2.setQuestion("What is javadca ?");

		Question question3 = new Question();
		question3.setQid(103);
		question3.setQuestion("What is java aaa?");

		List<Question> queList = new ArrayList<Question>();
		queList.add(question1);
		queList.add(question2);
		queList.add(question3);

		MyTest mytest1 = new MyTest();
		mytest1.setTestName("Java");
		mytest1.setTestLevel("225");

		mytest1.setQuestionSet(queList);

//			SessionFactory sessionFactory = null;
//			// configures settings from hibernate.cfg.xml
//			final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
//
//			try {
//				sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
//			} catch (Exception ex) {
//				System.out.println(ex.toString()); // If error display in console
//				StandardServiceRegistryBuilder.destroy(registry);
//			}
//			Session session = sessionFactory.openSession();
//			session.beginTransaction();
//			List<Student> studentlist = this.csvToclass();
//			studentlist.forEach(x -> session.save(x));
//			session.getTransaction().commit();
//			session.close();

		// use persistence.xml configuration

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Test_Question");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

//			List<Customer> custlist1 = this.CustomerDetals();
//			custlist1.forEach(x -> em.persist(x));
//			custlist1.forEach(x -> em.merge(x));

		em.merge(question1);
		em.merge(question2);
		em.merge(question3);
		em.merge(mytest1);
		em.getTransaction().commit();

		em.close();
		emf.close();

	}

}
