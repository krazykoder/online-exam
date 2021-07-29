package com.JPA.onlineExam.DBTests;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

import com.JPA.onlineExam.entity.AttemptedTest;
import com.JPA.onlineExam.entity.Question;
import com.JPA.onlineExam.entity.TestPaper;
import com.JPA.onlineExam.entity.User;

public class InitializeDatabase {

	// Get entity Manager
	myEntityManager M = new myEntityManager();

	@Test
	public void fillDatabase() throws IllegalStateException, FileNotFoundException {

		EntityManager em = M.getentitymanager();
		// You should create entity manger and factory ONLY ONCE.
		// Each creation will regenerate database and wipe out data with 'create' option
		// in persistence.xml

		// import all question to database
		Import_QuesCsv2DB ques = new Import_QuesCsv2DB();
		ques.importTodb(em);

//		// Generate tests with random questions		
		generateSampleTestPapers(em); // generate 4 tests

		// Generate some 'fake' attempted tests
		AttemptedTest t1 = createAttemptedTest(em, 1); // sample attempt 1
		AttemptedTest t2 = createAttemptedTest(em, 1); // sample attempt 2
		AttemptedTest t3 = createAttemptedTest(em, 2); // sample attempt 3
		AttemptedTest t4 = createAttemptedTest(em, 2); // sample attempt 3

		// Generate some fake users and map to AttemptedTest
		User u1 = new User(1, "Morris", "Lovemorris");
		List<AttemptedTest> p = new ArrayList();
		p.add(t1);
		p.add(t2);
		u1.setAtemptTestSet(p);
		createUser(u1);

//		System.out.println(t1.toString());

		User u2 = new User(2, "Hella", "Lovehella");
		List<AttemptedTest> q = new ArrayList();
		q.add(t3);
		q.add(t4);
//		q.add(t1); // will throw constraint violation error 
		u2.setAtemptTestSet(q);
		createUser(u2);

		User u3 = new User(3, "Alfredo", "pseudoCode123");
		createUser(u3);

		M.closeAll(); // remember to close the connection
	}

	/*****************************************************
	 * PERSIST USER OBJECT (SAMPLE)
	 ******************************************************/

	private void createUser(User userObbject) {
		EntityManager em = M.getentitymanager();
		em.getTransaction().begin();
		em.merge(userObbject);
		em.getTransaction().commit();

	}

	/*****************************************************
	 * GENERATE TEST PAPERS (SAMPLE)
	 ******************************************************/
	public void generateSampleTestPapers(EntityManager em) {

		// use persistence.xml configuration
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

	}

	public TestPaper generateTestPaper(EntityManager em) {

		// use persistence.xml configuration
		em.getTransaction().begin();

		Query query = em
				.createQuery("FROM Question where Qid>=FLOOR(RAND()*(25-10+1))+10 AND Qid<FLOOR(RAND()*(50-10+1))+30 ");
		List<Question> results = query.getResultList();

		for (Question obj : results) {
			System.out.println(obj.getQuestion() + "   " + obj.getChoice_1() + "   " + obj.getChoice_2() + "    "
					+ obj.getChoice_3() + "    " + obj.getChoice_4());

		}

		TestPaper test1 = new TestPaper();
		test1.setQuestionSet(results);
		test1.setTestName("Full Stack JAVA");
		test1.setTestLevel("I");

		TestPaper tp = em.merge(test1);

		em.getTransaction().commit();

		return tp;

	}

	/***************************************
	 * ATTEMPTED TEST GENERATION (SAMPLE)
	 ***************************************/

//	@Test
	public void createAttemptedTest() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Online_Exam");
		EntityManager em = emf.createEntityManager();
		createAttemptedTest(em, 1);
	}

// overload 
	public AttemptedTest createAttemptedTest(EntityManager em, int testID) {
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

		AttemptedTest at = em.merge(atest1);
		em.getTransaction().commit();

//		atest1 = em.find(AttemptedTest.class, atest1);

		return at;
	}

	private TestPaper getTestPaperObject(EntityManager em, int ID) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("FROM TestPaper where testId=" + ID);
		TestPaper testPaper = (TestPaper) query.getResultList().get(0);

		return testPaper;
	}

}
