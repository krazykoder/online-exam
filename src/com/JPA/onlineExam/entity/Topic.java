package com.JPA.onlineExam.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Topic")
public class Topic {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "topicId")
	private int topicId;

	@ManyToMany
	private List<TestPaper> TestPapers;

	// private List<AttemptedTest> TestAttempted;
	private String titletopic;
	private String content;

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public List<TestPaper> getTestPapers() {
		return TestPapers;
	}

	public void setTestPapers(List<TestPaper> testPapers) {
		TestPapers = testPapers;
	}

	public String getTitletopic() {
		return titletopic;
	}

	public void setTitletopic(String titletopic) {
		this.titletopic = titletopic;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Topics [topicId=" + topicId + ", TestPapers=" + TestPapers + ", titletopic=" + titletopic + ", content="
				+ content + "]";
	}

}
