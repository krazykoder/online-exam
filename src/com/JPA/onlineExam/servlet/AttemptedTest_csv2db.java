package com.JPA.onlineExam.servlet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

import com.JPA.onlineExam.entity.AttemptedTest;
import com.JPA.onlineExam.entity.Question;
import com.JPA.onlineExam.entity.TestPaper;

public class AttemptedTest_csv2db {

	// method to calculate finalscore

	public List<TestPaper> FetchTestpaper() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Online_Exam");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Query query = em.createQuery("FROM MyTest where testId>=1  AND testId<=4");
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

		return testPaper;

	}

//	@Test
//	public void fetchtest() {
//		System.out.println(FetchAttemptedTestPaper());
//		System.out.println(FetchAttemptedTestPaper());
//
//	}

	public TestPaper FetchTestpaper1(int ID) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Online_Exam");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Query query = em.createQuery("FROM MyTest where testId=ID");
		TestPaper testPaper = (TestPaper) query.getResultList().get(0);

		for (Question q : testPaper.getQuestionSet()) {
			System.out.println(q.getQuestion() + "        " + q.getChoice_1() + "     " + q.getChoice_2() + "      "
					+ q.getChoice_3() + "     " + q.getChoice_4());
		}
		System.out.println(
				testPaper.getId() + "   " + testPaper.getTestName() + "    " + testPaper.getTestLevel() + "    ");

		em.close();
		emf.close();

		return testPaper;

	}

	// key value pair for question and answer.
	// @Test
	public Map<Question, Character> testAnswers(TestPaper testPaper) {

		Map<Question, Character> hashmap = new HashMap<Question, Character>();
		Random randNum = new Random();

		char user_ans = ' ';
		char[] alphabet = { 'A', 'B', 'C', 'D' };

		// user_ans=(int)(Math.random()*(max-min+1)+min);
		System.out.println(testPaper.toString());

		List<Question> obj1 = testPaper.getQuestionSet();
		for (Question q : obj1) {
			user_ans = alphabet[(int) (Math.random() * 10 % 4)];
			hashmap.put(q, user_ans);
			// System.out.println(q.toString());
		}

		return hashmap;

	}

	public int calculateFinalScore(TestPaper testPaper) {

		int finalScore = 0;
		// for (MyTest obj : testPaper) {
		// user_ans=(int)(Math.random()*(max-min+1)+min);
		// System.out.println(obj.toString());
		// finalScore = 0;
		Map<Question, Character> hashmap = new HashMap<Question, Character>();
		hashmap = testAnswers(testPaper);

		// printing the objects of hashmap
		Set<Map.Entry<Question, Character>> entries = hashmap.entrySet();
		for (Map.Entry<Question, Character> hm : entries) {
			String ans = hm.getKey().getAnswer();
			char user_ans = hm.getValue();
			String st = Character.toString(user_ans);
			// System.out.println(x + " : " + y);
			if (ans.equals(st)) {
				finalScore += 1;
			}

		}

		return finalScore;
	}

	// @Test
	public List<AttemptedTest> FetchAttemptedTestPaper() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Online_Exam");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Query query = em.createQuery("FROM AttemptedTest where sl_no=1");
		List<AttemptedTest> testPaper = query.getResultList();
		for (AttemptedTest obj : testPaper) {

			System.out.println(obj.getQuestionAnswersSet() + "\n" + obj.getFinalScore() + "    ");

		}

		em.close();
		emf.close();
		return testPaper;
	}

	@Test
	public void insertAttemptedTest() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Online_Exam");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		List<TestPaper> test = FetchTestpaper();

		AttemptedTest test2 = new AttemptedTest();

		Map<Question, Character> hashmap = new HashMap<Question, Character>();

		int finalScore = 0;

		//

		for (TestPaper test1 : test) {

			if (test1.getId() == 1) {

				test2.setTest(test1);
				finalScore = calculateFinalScore(test1);
				hashmap = testAnswers(test1);
				// printing the objects of hashmap
				Set<Map.Entry<Question, Character>> entries = hashmap.entrySet();
				for (Map.Entry<Question, Character> hm : entries) {
					Question x = hm.getKey();
					char y = hm.getValue();
					System.out.println(x + " : " + y);
				}

				test2.setFinalScore(finalScore);
				test2.setQuestionAnswersSet(hashmap);

			}
		}

		em.merge(test2);
		em.getTransaction().commit();

		em.close();
		emf.close();
	}
}
