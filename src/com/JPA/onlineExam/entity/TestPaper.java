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
	@Column(name = "Id")
	private int Id;

	@Column(name = "testName")
	private String testName;

	@Column(name = "testLevel")
	private String testLevel;

	@ManyToMany
	private List<Topic> topics;

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Question> questionSet;

	public List<Question> getQuestionSet() {
		return questionSet;
	}

	public void setQuestionSet(List<Question> questionSet) {
		this.questionSet = questionSet;
	}

	public int getId() {
		return Id;
	}

	public void setId(int Id) {
		this.Id = Id;
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
		return "MyTest [Id=" + Id + ", testName=" + testName + ", testLevel=" + testLevel + ", questionSet="
				+ questionSet + "]";
	}

}
