package com.JPA.onlineExam.entity;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AttemptedTest")
public class AttemptedTest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int Id;

//	@Column(name = "user_ans")
//	private char user_ans;

	@Column(name = "finalScore")
	private int finalScore;

	@ManyToOne
	private TestPaper test;

	@OneToOne
	private Score score;

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	@ElementCollection
	private Map<Question, Character> questionAnswersSet;

	public int getId() {
		return Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}

	public TestPaper getTest() {
		return test;
	}

	public void setTest(TestPaper test) {
		this.test = test;
	}

//	public char getUser_ans() {
//		return user_ans;
//	}
//
//	public void setUser_ans(char user_ans) {
//
//		this.user_ans = user_ans;
//	}

	public int getFinalScore() {
		return finalScore;
	}

	public void setFinalScore(int finalScore) {
		this.finalScore = finalScore;
	}

	public Map<Question, Character> getQuestionAnswersSet() {
		return questionAnswersSet;
	}

	public void setQuestionAnswersSet(Map<Question, Character> questionAnswersSet) {
		this.questionAnswersSet = questionAnswersSet;
	}

	@Override
	public String toString() {
		return "AttemptedTest [Id=" + Id + ", finalScore=" + finalScore + ", questionAnswersSet=" + questionAnswersSet
				+ "]";
	}

}
