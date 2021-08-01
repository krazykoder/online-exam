package com.JPA.onlineExam.servlet;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
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
import com.JPA.onlineExam.entity.Topic;
import com.JPA.onlineExam.entity.User;

public class UserToDb {
	@Test
	public void userToDb() throws IllegalStateException, FileNotFoundException {

		// Get entity Manager
		myEntityManager M = new myEntityManager();
		EntityManager em = M.getentitymanager();
		// You should create entity manger and factory ONLY ONCE.
		// Each creation will regenerate database and wipe out data with 'create' option
		// in persistence.xml

		// import all question to database
		QuesCsv2db_Insert ques = new QuesCsv2db_Insert();
		ques.importTodb(em);

		// import some topics
		generateTopics(em);

//		// Generate tests with random questions		
		generateTestPaper(em); // generate 4 tests

		// Generate some 'fake' attempted tests
		createAttemptedTest(em); // sample attempt 1
//		createAttemptedTest(em); // sample attempt 2
//		createAttemptedTest(em); // sample attempt 3
//		createAttemptedTest(em); // sample attempt 3

		// Gererate users
		createUser(em);

		M.closeAll(); // remember to close the connection
	}

	public void generateTopics(EntityManager em) {

		em.getTransaction().begin();

		Topic topic1 = new Topic();
		Topic topic2 = new Topic();
		Topic topic3 = new Topic();
//		Topics topic4 = new Topics();
//		Topics topic5 = new Topics();
//		Topics topic6 = new Topics();

		List<TestPaper> testPapers = FetchTestpaper(em);

		topic1.setTestPapers(testPapers);
		topic1.setContent("Hello content");
		topic1.setTitletopic("afjfajfl");
		em.merge(topic1);

		testPapers = FetchTestpaper(em);

		topic2.setTestPapers(testPapers);
		topic2.setContent("Pqljjv");
		topic2.setTitletopic("vnsdnlsl");
		em.merge(topic2);

		testPapers = FetchTestpaper(em);

		topic3.setTestPapers(testPapers);
		topic3.setContent("gdgdgdlk");
		topic3.setTitletopic("sjsljlskjglk");
		em.merge(topic3);

		em.getTransaction().commit();

	}

	/*****************************************************
	 * GENERATE TEST PAPERS (SAMPLE)
	 ******************************************************/
	public void generateTestPaper(EntityManager em) {

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

	/***************************************
	 * ATTEMPTED TEST GENERATION (SAMPLE)
	 ***************************************/

//		@Test
//	public void createAttemptedTest() {
//
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Online_Exam");
//		EntityManager em = emf.createEntityManager();
//		createAttemptedTest(em);
//	}

	// overload
	public void createAttemptedTest(EntityManager em) {
		em.getTransaction().begin();

		// syso the map
//		for (Map.Entry<Question, Character> item : mymap.entrySet())
//			System.out.println(item.getKey().toString() + "::" + item.getValue().toString());

//	    create the attempted test object  
		List<TestPaper> test = FetchTestpaper(em);
		Map<Question, Character> hashmap = new HashMap<Question, Character>();
		AttemptedTest test2 = new AttemptedTest();
		int finalScore = 0;

		for (TestPaper test1 : test) {

			int no_of_attempt = (int) (Math.random() * (5 - 1 + 1) + 1);

			for (int i = 0; i < no_of_attempt; i++) {

				test2.setTest(test1);
				finalScore = calculateFinalScore(test1);
				hashmap = testAnswers(test1);
				test2.setFinalScore(finalScore);
				test2.setQuestionAnswersSet(hashmap);

				em.merge(test2);
			}

		}
		em.getTransaction().commit();
	}

	public int calculateFinalScore(TestPaper testPaper) {

		int finalScore = 0;
		// for (TestPaper obj : testPaper) {
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

//	private TestPaper getTestPaperObject(EntityManager em, int ID) {
//		// TODO Auto-generated method stub
//		Query query = em.createQuery("FROM TestPaper where testId=" + ID);
//		TestPaper testPaper = (TestPaper) query.getResultList().get(0);
//
//		return testPaper;
//	}

	public List<TestPaper> FetchTestpaper(EntityManager em) {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Online_Exam");
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();

		Query query = em.createQuery("FROM TestPaper where testId>=1 AND testId<=4");
		List<TestPaper> testPaper = query.getResultList();
		for (TestPaper obj : testPaper) {
			for (Question q : obj.getQuestionSet()) {
				System.out.println(q.getQuestion() + "        " + q.getChoice_1() + "     " + q.getChoice_2() + "      "
						+ q.getChoice_3() + "     " + q.getChoice_4());
			}
			System.out.println(obj.getTestId() + "   " + obj.getTestName() + "    " + obj.getTestLevel() + "    ");

		}

//		em.close();
//		emf.close();

		return testPaper;

	}

	// create user and update the friendship mapping
	public void createUser(EntityManager em) {
		em.getTransaction().begin();

		User user1 = new User();
		User user2 = new User();
		User user3 = new User();
		User user4 = new User();
		User user5 = new User();
		User user6 = new User();
		User user7 = new User();
		User user8 = new User();

		List<TestPaper> unattemptTestSet = FetchTestpaper(em);

		List<AttemptedTest> atemptTestSet = FetchAttemptedTestPaper1(1, 2, em);

		// List<User> friends = new ArrayList<User>();

		user1.setUserName("Sharif");
		user1.setPassword("password1");
		user1.setUnattemptTestSet(unattemptTestSet);
		user1.setAtemptTestSet(atemptTestSet);
		// user1.setFriends(friends);

		em.merge(user1);

		atemptTestSet = FetchAttemptedTestPaper1(3, 4, em);

		user2.setUserName("Ramesh");
		user2.setPassword("password2");
		user2.setUnattemptTestSet(unattemptTestSet);
		user2.setAtemptTestSet(atemptTestSet);
//		 user2.setFriends(friends);

		em.merge(user2);
		atemptTestSet = FetchAttemptedTestPaper1(5, 6, em);

		user3.setUserName("Nilesh");
		user3.setPassword("password3");
		user3.setUnattemptTestSet(unattemptTestSet);
		user3.setAtemptTestSet(atemptTestSet);
////		user3.setFriends(friends);
//
		em.merge(user3);
		atemptTestSet = FetchAttemptedTestPaper1(7, 8, em);
//
		user4.setUserName("Somesh");
		user4.setPassword("password4");
		user4.setUnattemptTestSet(unattemptTestSet);
		user4.setAtemptTestSet(atemptTestSet);
////	    user4.setFriends(friends);
//
		em.merge(user4);
		atemptTestSet = FetchAttemptedTestPaper1(9, 10, em);

		user5.setUserName("Farukh");
		user5.setPassword("password5");
		user5.setUnattemptTestSet(unattemptTestSet);
		user5.setAtemptTestSet(atemptTestSet);

		em.merge(user5);
		atemptTestSet = FetchAttemptedTestPaper1(11, 12, em);

		user6.setUserName("Sarukh");
		user6.setPassword("password6");
		user6.setUnattemptTestSet(unattemptTestSet);
		user6.setAtemptTestSet(atemptTestSet);

		em.merge(user6);
		atemptTestSet = FetchAttemptedTestPaper1(13, 14, em);

		user7.setUserName("Amir");
		user7.setPassword("password7");
		user7.setUnattemptTestSet(unattemptTestSet);
		user7.setAtemptTestSet(atemptTestSet);

		em.merge(user7);
		atemptTestSet = FetchAttemptedTestPaper1(15, 16, em);

		user8.setUserName("Alam");
		user8.setPassword("password8");
		user8.setUnattemptTestSet(unattemptTestSet);
		user8.setAtemptTestSet(atemptTestSet);

		em.merge(user8);

		em.getTransaction().commit();

		update_userToDb(em);
	}

	public void update_userToDb(EntityManager em) {

//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Online_Exam");
//		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		List<User> friends = new ArrayList<User>();

		List<User> User_obj = new ArrayList<User>();
		User_obj = FetchUser(em);

		for (User u : User_obj) {
			friends = Fetch_friendList(em);
			u.setFriends(friends);
			em.merge(u);
		}

		em.getTransaction().commit();

//		em.close();
//		emf.close();

	}

	public List<User> FetchUser(EntityManager em) {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Online_Exam");
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();

		Query query = em.createQuery("FROM User ");
		List<User> users = query.getResultList();

		for (User obj : users) {

			System.out.println(obj.getUserName() + " " + obj.getPassword());
			// System.out.println(obj + obj.getUserName());

		}

//		em.close();
//		emf.close();
		return users;
	}

	public List<User> Fetch_friendList(EntityManager em) {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Online_Exam");
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();

		Query query = em.createQuery("FROM User ");
		List<User> users = query.getResultList();

		Collections.shuffle(users);

		// System.out.println(users.size());

		int length = (int) (Math.random() * (8 - 1 + 1) + 1);
		System.out.println(length);
		List<User> randomUsers = users.subList(0, length);

		for (User obj : randomUsers) {

			System.out.println(obj.getUserName() + " " + obj.getPassword());
			// System.out.println(obj + obj.getUserName());

		}

//		em.close();
//		emf.close();
		return randomUsers;
	}

	public List<AttemptedTest> FetchAttemptedTestPaper1(int start, int end, EntityManager em) {

		// em.getTransaction().begin();

		Query query = em.createQuery("FROM AttemptedTest where sl_no>=" + start + " AND sl_no <=" + end);
		List<AttemptedTest> testPaper = query.getResultList();
		for (AttemptedTest obj : testPaper) {

			System.out.println(obj.getSl_no());// .getQuestionAnswersSet() + "\n" + obj.getFinalScore() + " ");

		}

		// em.close();
		// emf.close();
		return testPaper;
	}

}

class myEntityManager {
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
