package com.JPA.onlineExam.servlet;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.JPA.onlineExam.entity.TestPaper;
import com.JPA.onlineExam.entity.Question;

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

		TestPaper mytest1 = new TestPaper();
		mytest1.setTestName("Java");
		mytest1.setTestLevel("1");

		mytest1.setQuestionSet(queList);

//			

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Test_Question");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		em.merge(question1);
		em.merge(question2);
		em.merge(question3);
		em.merge(mytest1);
		em.getTransaction().commit();

		em.close();
		emf.close();

	}

}
