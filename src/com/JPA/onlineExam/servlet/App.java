package com.JPA.onlineExam.servlet;

import java.io.FileNotFoundException;

import javax.persistence.EntityManager;

import org.junit.Test;

import com.JPA.onlineExam.entity.myEntityManager;

public class App {

	@Test
	public void fillDatabase() throws IllegalStateException, FileNotFoundException {

		// Get entity Manager
		myEntityManager M = new myEntityManager();
		EntityManager em = M.getentitymanager();

		// import all question to database
		QuesCsv2db_Insert ques = new QuesCsv2db_Insert();
		ques.importTodb(em);

//		// Generate tests with random questions
		MyTest_csv2db mytest = new MyTest_csv2db();
		mytest.generateTestPaper(em); // generate 4 tests

		// Generate some 'fake' attempted tests
		AttemptedTest_csv2db am = new AttemptedTest_csv2db();
		am.insertAttemptedTest(em); // sample attempt 1
		am.insertAttemptedTest(em); // sample attempt 2
		am.insertAttemptedTest(em); // sample attempt 3

		M.closeAll(); // remember to close the connection
	}

	public void faketest() {

	}

}
