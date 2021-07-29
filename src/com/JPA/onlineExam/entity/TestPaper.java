package com.JPA.onlineExam.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TestPaper")
public class TestPaper {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "testId")
	private int testId;

	@Column(name = "testName")
	private String testName;

	@Column(name = "testLevel")
	private String testLevel;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Question> questionSet;

//	@OneToMany
//	@JoinColumn(name = "testId")
//	private List<AttemptedTest> testAttempt;

////	public void addQuestion(Question question) {
////		questionSet.add(question);
////	}

//	public List<AttemptedTest> getTestAttempt() {
//		return testAttempt;
//	}
//
//	public void setTestAttempt(List<AttemptedTest> testAttempt) {
//		this.testAttempt = testAttempt;
//	}

	public List<Question> getQuestionSet() {
		return questionSet;
	}

	public void setQuestionSet(List<Question> questionSet) {
		this.questionSet = questionSet;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getTestLevel() {
		return testLevel;
	}

	public void setTestLevel(String testLevel) {
		this.testLevel = testLevel;
	}

	@Override
	public String toString() {
		return "MyTest [testId=" + testId + ", testName=" + testName + ", testLevel=" + testLevel + ", questionSet="
				+ questionSet + "]";
	}

}
