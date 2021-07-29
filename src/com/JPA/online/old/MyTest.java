package com.JPA.online.old;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.JPA.onlineExam.entity.Question;

@Entity
@Table(name = "test")
public class MyTest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "testId")
	private int testId;

	@Column(name = "testName")
	private String testName;

	@Column(name = "testLevel")
	private String testLevel;

	@OneToMany //(mappedBy = "test") // removed object reference
	private List<Question> questionSet = new ArrayList<Question>();

	public void addQuestion(Question question) {
		questionSet.add(question);
	}

	public List<Question> getQuestionSet() {
		return questionSet;
	}

	public void setQuestionSet(List<Question> questionSet) {
		this.questionSet = questionSet;
	}

	// method to generate questions
	/*
	 * @SuppressWarnings("unused") private void generateQuestion() { for (int
	 * question = 0; question < questionSet.size(); question++) {
	 * System.out.println(questionSet.get(question).getQuestion()); int numChoices =
	 * questionSet.get(question).getChoices().size();
	 * 
	 * // show choices from questions in question set
	 * 
	 * for (int choice = 0; choice < numChoices; choice++) {
	 * System.out.println((choice + 1) + ":" +
	 * questionSet.get(question).getChoices().get(choice)); } }
	 * 
	 * }
	 */

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
		return "Test [testId=" + testId + ", testName=" + testName + ", testLevel=" + testLevel + "]";
	}

}
