package com.JPA.onlineExam.DBTests;

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

		Query query = em.createQuery("FROM TestPaper where testId=1");
		List<TestPaper> testPaper = query.getResultList();
		for (TestPaper obj : testPaper) {
			for (Question q : obj.getQuestionSet()) {
				System.out.println(q.getQuestion() + "        " + q.getChoice_1() + "     " + q.getChoice_2() + "      "
						+ q.getChoice_3() + "     " + q.getChoice_4());
			}
			System.out.println(obj.getTestId() + "   " + obj.getTestName() + "    " + obj.getTestLevel() + "    ");

		}

		em.close();
		emf.close();

		return testPaper;

	}

	@SuppressWarnings("unchecked")
	public List<TestPaper> FetchTestpaper(EntityManager em) {

//		em.getTransaction().begin();

		Query query = em.createQuery("FROM TestPaper where testId=1");
		List<TestPaper> testPaper = query.getResultList();
		for (TestPaper obj : testPaper) {
			for (Question q : obj.getQuestionSet()) {
				System.out.println(q.getQuestion() + "        " + q.getChoice_1() + "     " + q.getChoice_2() + "      "
						+ q.getChoice_3() + "     " + q.getChoice_4());
			}
			System.out.println(obj.getTestId() + "   " + obj.getTestName() + "    " + obj.getTestLevel() + "    ");

		}

		return testPaper;

	}

//res=res+alphabet[(int)(Math.random()*10%26)];

	// key value pair for question and answer.
	// @Test
	public Map<Question, Character> testAnswers() {

		Map<Question, Character> hashmap = new HashMap<Question, Character>();
		Random randNum = new Random();
		List<TestPaper> testPaper = FetchTestpaper();
		char user_ans = ' ';
		char[] alphabet = { 'A', 'B', 'C', 'D' };

		for (TestPaper obj : testPaper) {
			// user_ans=(int)(Math.random()*(max-min+1)+min);
			System.out.println(obj.toString());

			List<Question> obj1 = obj.getQuestionSet();
			for (Question q : obj1) {
				user_ans = alphabet[(int) (Math.random() * 10 % 4)];
				hashmap.put(q, user_ans);
				// System.out.println(q.toString());
			}
		}

		return hashmap;
	}

	public Map<Question, Character> testAnswers(EntityManager em) {

		Map<Question, Character> hashmap = new HashMap<Question, Character>();
		List<TestPaper> testPaper = FetchTestpaper(em);
		Random randNum = new Random();
		char user_ans = ' ';
		char[] alphabet = { 'A', 'B', 'C', 'D' };

		for (TestPaper obj : testPaper) {
			// user_ans=(int)(Math.random()*(max-min+1)+min);
			System.out.println(obj.toString());

			List<Question> obj1 = obj.getQuestionSet();
			for (Question q : obj1) {
				user_ans = alphabet[(int) (Math.random() * 10 % 4)];
				hashmap.put(q, user_ans);
				// System.out.println(q.toString());
			}
		}

		return hashmap;
	}

	public int calculateFinalScore() {
		List<TestPaper> testPaper = FetchTestpaper();
		int finalScore = 0;
		for (TestPaper obj : testPaper) {
			// user_ans=(int)(Math.random()*(max-min+1)+min);
			// System.out.println(obj.toString());

			Map<Question, Character> hashmap = new HashMap<Question, Character>();
			hashmap = testAnswers();

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

		}

		return finalScore;
	}

	// @Test
	public void FetchAttemptedTestPaper() {
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
	}

	@Test
	public void insertAttemptedTest() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Online_Exam");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		AttemptedTest test2 = new AttemptedTest();
		int finalScore = calculateFinalScore();

		Map<Question, Character> hashmap = new HashMap<Question, Character>();
		hashmap = testAnswers();

		// printing the objects of hashmap
		Set<Map.Entry<Question, Character>> entries = hashmap.entrySet();
		for (Map.Entry<Question, Character> hm : entries) {
			Question x = hm.getKey();
			char y = hm.getValue();
			System.out.println(x + " : " + y);
		}

		test2.setFinalScore(finalScore);
		test2.setQuestionAnswersSet(hashmap);

		em.merge(test2);
		em.getTransaction().commit();

		em.close();
		emf.close();
	}

	public void insertAttemptedTest(EntityManager em) {

		em.getTransaction().begin();

		AttemptedTest atest1 = new AttemptedTest();
//		int finalScore = calculateFinalScore();

		Map<Question, Character> hashmap = new HashMap<Question, Character>();
		hashmap = testAnswers(em);

		// printing the objects of hashmap
		Set<Map.Entry<Question, Character>> entries = hashmap.entrySet();
		for (Map.Entry<Question, Character> hm : entries) {
			Question x = hm.getKey();
			char y = hm.getValue();
			System.out.println(x + " : " + y);
		}

//		test2.setFinalScore(finalScore);
		atest1.setQuestionAnswersSet(hashmap);
//		atest1.setTest(test);

		em.merge(atest1);
		em.getTransaction().commit();
	}

	private TestPaper getTestPaperObject(EntityManager em, int ID) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("FROM TestPaper where testId=" + ID);
		TestPaper testPaper = (TestPaper) query.getResultList().get(0);

		return testPaper;
	}

	@Test
	public void createAttemptedTest() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Online_Exam");
		EntityManager em = emf.createEntityManager();
		createAttemptedTest(em, 1);
	}

// overload 
	public void createAttemptedTest(EntityManager em, int testID) {
		em.getTransaction().begin();

//		int finalScore = calculateFinalScore();

		// fetch a test paper by ID
		TestPaper t = getTestPaperObject(em, testID);

		// create a collection for QuestionAnswersSet
		Map<Question, Character> mymap = new HashMap<Question, Character>();
		Random randNum = new Random();
		char user_ans = ' ';
		char[] alphabet = { 'A', 'B', 'C', 'D' };
		List<Question> qObject = t.getQuestionSet();
		for (Question q : qObject) {
			user_ans = alphabet[(int) (Math.random() * 10 % 4)];
			mymap.put(q, user_ans);
			// System.out.println(q.toString());
		}

		// syso the map
		for (Map.Entry<Question, Character> item : mymap.entrySet())
			System.out.println(item.getKey().toString() + "::" + item.getValue().toString());

		// printing the objects of hashmap
//		Set<Map.Entry<Question, Character>> entries = mymap.entrySet();
//		for (Map.Entry<Question, Character> hm : entries) {
//			Question x = hm.getKey();
//			char y = hm.getValue();
//			System.out.println(x + " : " + y);
//		}

//		create the attempted test object object 
		AttemptedTest atest1 = new AttemptedTest();
		atest1.setTest(t);
		atest1.setQuestionAnswersSet(mymap);
//		atest1.setFinalScore(finalScore);

		em.merge(atest1);
		em.getTransaction().commit();
	}
}
