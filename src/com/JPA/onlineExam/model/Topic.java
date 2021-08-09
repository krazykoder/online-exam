package com.JPA.onlineExam.model;

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
	@Column(name = "Id")
	private int Id;

	@ManyToMany
	private List<TestPaper> TestPapers;

	// private List<AttemptedTest> TestAttempted;
	private String titletopic;
	private String content;

	public int getId() {
		return Id;
	}

	public void setId(int Id) {
		this.Id = Id;
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
		return "Topics [Id=" + Id + ", TestPapers=" + TestPapers + ", titletopic=" + titletopic + ", content=" + content
				+ "]";
	}

}
