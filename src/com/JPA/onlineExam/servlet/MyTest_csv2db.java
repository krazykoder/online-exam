package com.JPA.onlineExam.servlet;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

import com.JPA.onlineExam.entity.Question;
import com.JPA.onlineExam.entity.TestPaper;

public class MyTest_csv2db {

	// @Test
	public void FetchTest() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Online_Exam");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Query query = em.createQuery("FROM MyTest where testId=1");
		List<TestPaper> testPaper = query.getResultList();
		for (TestPaper obj : testPaper) {
			for (Question q : obj.getQuestionSet()) {
				System.out.println(q.getQuestion() + "        " + q.getChoice_1() + "     " + q.getChoice_2() + "      "
						+ q.getChoice_3() + "     " + q.getChoice_4());
			}
			System.out.println(obj.getId() + "   " + obj.getTestName() + "    " + obj.getTestLevel() + "    ");

		}

		em.close();
		emf.close();

	}

	@Test
	public void generateQuestions() {

		// use persistence.xml configuration

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Online_Exam");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		for (int i = 1; i <= 4; i++) {
			Query query = em.createQuery(
					"FROM Question where Qid>=FLOOR(RAND()*(25-10+1))+10 AND Qid<FLOOR(RAND()*(50-10+1))+30 ");
			List<Question> results = query.getResultList();

			for (Question obj : results) {
				System.out.println(obj.getQuestion() + "   " + obj.getChoice_1() + "   " + obj.getChoice_2() + "    "
						+ obj.getChoice_3() + "    " + obj.getChoice_4());

			}

			TestPaper test1 = new TestPaper();
			test1.setQuestionSet(results);
			test1.setTestName("Full Stack JAVA");
			test1.setTestLevel("I");
			em.merge(test1);
		}

		em.getTransaction().commit();

		em.close();
		emf.close();

	}

}
