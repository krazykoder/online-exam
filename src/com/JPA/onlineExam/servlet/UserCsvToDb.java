//package com.JPA.onlineExam.servlet;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import javax.persistence.Query;
//
//import org.junit.Test;
//
//import com.JPA.onlineExam.entity.AttemptedTest;
//import com.JPA.onlineExam.entity.Question;
//import com.JPA.onlineExam.entity.TestPaper;
//import com.JPA.onlineExam.entity.Topics;
//import com.JPA.onlineExam.entity.User;
//
//public class UserCsvToDb {
//
////	@Test
//	public void userToDb() {
//
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Online_Exam");
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//
//		User user1 = new User();
//		User user2 = new User();
//		User user3 = new User();
//		User user4 = new User();
//
//		List<TestPaper> unattemptTestSet = FetchTestpaper();
//
//		List<AttemptedTest> atemptTestSet = FetchAttemptedTestPaper1(1, 3);
//
//		List<User> friends = new ArrayList<User>();
//
//		user1.setUserName("Sharif");
//		user1.setPassword("password1");
//		user1.setUnattemptTestSet(unattemptTestSet);
//		user1.setAtemptTestSet(atemptTestSet);
//		// user1.setFriends(friends);
//
////		em.merge(user1);
//
//		List<AttemptedTest> atemptTestSet2 = FetchAttemptedTestPaper1(4, 5);
//
//		user2.setUserName("Ramesh");
//		user2.setPassword("password2");
//		user2.setUnattemptTestSet(unattemptTestSet);
//		user2.setAtemptTestSet(atemptTestSet2);
////		 user2.setFriends(friends);
//
//		em.merge(user2);
////
////		user3.setUserName("Nilesh");
////		user3.setPassword("password3");
////		user3.setUnattemptTestSet(unattemptTestSet);
////		user3.setAtemptTestSet(atemptTestSet);
//////		user3.setFriends(friends);
////
////		em.merge(user3);
////
////		user4.setUserName("Somesh");
////		user4.setPassword("password4");
////		user4.setUnattemptTestSet(unattemptTestSet);
////		user4.setAtemptTestSet(atemptTestSet);
//////	    user4.setFriends(friends);
////
////		em.merge(user4);
//		em.getTransaction().commit();
//
//		em.close();
//		emf.close();
//	}
//
////	@Test
//	public void Fetch() {
//		System.out.println(FetchAttemptedTestPaper1(1, 3));
//		System.out.println(FetchAttemptedTestPaper1(3, 5));
//	}
//
//	@Test
//	public void update_userToDb() {
//
////		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Online_Exam");
////		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//
//		List<User> friends = new ArrayList<User>();
//		friends = FetchUser();
//
//		for (User u : friends) {
//			u.setFriends(friends);
//			em.merge(u);
//		}
//
//		em.getTransaction().commit();
//
////		em.close();
////		emf.close();
//
//	}
//
//	public void createTopics(EntityManager em) {
//		em.getTransaction().begin();
//
//		List<User> users = new ArrayList<>();
//		users = FetchUsers();
//
////	    create the attempted test object  
//		List<TestPaper> test = FetchTestpaper(em);
//		// Map<Question, Character> hashmap = new HashMap<Question, Character>();
//		Topics topic = new Topics();
//		int finalScore = 0;
//
//		for (User u : users) {
//
//			// int no_of_attempt = (int) (Math.random() * (5 - 1 + 1) + 1);
//
//			// suppose 10 topics we want to generate for each user
//
//			for (int i = 0; i < 10; i++) {
//
//				topic.setTestPapers(test);
//				topic.setContent(content);
//				topic.setTitletopic(titletopic);
//				// finalScore = calculateFinalScore(test1);
//
//				em.merge(topic);
//			}
//
//		}
//		em.getTransaction().commit();
//	}
//
////	public Map<Topics, Score> topic_Score_object(Topics topics, Score scores) {
////
////		Map<Topics, Score> hashmap = new HashMap<Topics, Score>();
////
////		hashmap.put(topics, scores);
////
////		return hashmap;
////
////	}
//
//	public List<Topics> FetchTopics(EntityManager em) {
////		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Online_Exam");
////		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//
//		Query query = em.createQuery("FROM Topics where topic_id>=1 AND topic_id <=10");
//		List<Topics> topics = query.getResultList();
//		for (Topics obj : topics) {
//
//			System.out.println(obj.getTitletopic() + " " + obj.getContent() + "  " + obj.getTestPapers());
//
//		}
//
////		em.close();
////		emf.close();
//		return topics;
//	}
//
//	// topic wise score
//	public void calculatetopic_score() {
//		// fetch user
//		List<User> users = new ArrayList<>();
//		users = FetchUsers();
//		for (User u : users) {
//			u.getTopicsScoreSet();
//		}
//
//		// iterate and find the objects of testpapers
//
//		//
//
//	}
//
//	// topic wise percentile
//	// PERCENTILE = (NUMBER OF STUDENTS WHO SCORED BELOW OR EQUAL TO THE DESIRED
//	// STUDENT/ TOTAL NUMBER OF STUDENTS – 1) * 100
//	public void calculate_Percentile() {
//
//		List<AttemptedTest> att_test = new ArrayList<>();
//		att_test = FetchAttemptedTestPaper();
//
//		for (AttemptedTest test : att_test) {
//			test.getFinalScore();
//		}
//
//	}
//
//	// common test for all users
//	public void calculate_globalScore() {
//
//		// filter the global test from the list of attempted test along with scores.
//
//	}
//
////
////	public List<Score> FetchScore(EntityManager em) {
//////		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Online_Exam");
//////		EntityManager em = emf.createEntityManager();
////		em.getTransaction().begin();
////
////		Query query = em.createQuery("FROM Score where user_id>=1 AND user_id <=4");
////		List<User> users = query.getResultList();
////		for (User obj : users) {
////
////			System.out.println(obj.getUserName() + "\n" + obj.getPassword() + "    ");
////
////		}
////
////		em.close();
////		emf.close();
////		return scores;
////	}
//	public List<AttemptedTest> FetchAttemptedTestPaper() {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Online_Exam");
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//
//		Query query = em.createQuery("FROM AttemptedTest where sl_no=1");
//		List<AttemptedTest> testPaper = query.getResultList();
//		for (AttemptedTest obj : testPaper) {
//
//			System.out.println(obj.getQuestionAnswersSet() + "\n" + obj.getFinalScore() + "    ");
//
//		}
//
//		em.close();
//		emf.close();
//		return testPaper;
//	}
//
//	public List<User> FetchUser() {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Online_Exam");
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//
//		Query query = em.createQuery("FROM User ");
//		List<User> users = query.getResultList();
//		for (User obj : users) {
//
//			System.out.println(obj.getUserName() + "\n" + obj.getPassword() + "    ");
//
//		}
//
//		em.close();
//		emf.close();
//		return users;
//	}
//
//	EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Online_Exam");
//	EntityManager em = emf.createEntityManager();
//
//	public List<AttemptedTest> FetchAttemptedTestPaper1(int start, int end) {
//
//		// em.getTransaction().begin();
//
//		Query query = em.createQuery("FROM AttemptedTest where sl_no>=" + start + " AND sl_no <=" + end);
//		List<AttemptedTest> testPaper = query.getResultList();
//		for (AttemptedTest obj : testPaper) {
//
//			System.out.println(obj.getSl_no());// .getQuestionAnswersSet() + "\n" + obj.getFinalScore() + " ");
//
//		}
//
//		// em.close();
//		// emf.close();
//		return testPaper;
//	}
//
//	public List<TestPaper> FetchTestpaper() {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Online_Exam");
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//
//		Query query = em.createQuery("FROM MyTest where testId>=1 AND testId<=4");
//		List<TestPaper> testPaper = query.getResultList();
//		for (TestPaper obj : testPaper) {
//			for (Question q : obj.getQuestionSet()) {
//				System.out.println(q.getQuestion() + "        " + q.getChoice_1() + "     " + q.getChoice_2() + "      "
//						+ q.getChoice_3() + "     " + q.getChoice_4());
//			}
//			System.out.println(obj.getTestId() + "   " + obj.getTestName() + "    " + obj.getTestLevel() + "    ");
//
//		}
//
//		em.close();
//		emf.close();
//
//		return testPaper;
//
//	}
//
////	public User addFriend() {
////
////	}
////
////	public User removeFriend() {
////
////	}
//}
