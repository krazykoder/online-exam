package com.JPA.onlineExam.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Embeddable
@Entity
@Table(name = "Question")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int Qid;
	@Column(length = 3000)
	private String Question;
//	private ArrayList<String> choices;
	@Column(length = 1000)
	private String choice_1;
	@Column(length = 1000)
	private String choice_2;
	@Column(length = 1000)
	private String choice_3;
	@Column(length = 1000)
	private String choice_4;
	@Column(length = 1000)
	private String answer;

//	@ManyToOne
//	private MyTest test;

//	public Question(String question, String[] choices, String answer) {
//		this.question = question;
//		this.choices = new ArrayList<String>();
//		for (int i = 0; i < choices.length; i++) {
//			this.choices.add(choices[i]);
//		}
//
//		// make sure each test shows questions in different order
//		Collections.shuffle(this.choices);
//		this.answer = answer;
//	}

	public Question() {

	}

	public int getQid() {
		return Qid;
	}

	public void setQid(int qid) {
		Qid = qid;
	}

//	public MyTest getTest() {
//		return test;
//	}
//
//	public void setTest(MyTest test) {
//		this.test = test;
//	}

	public void setQuestion(String question) {
		this.Question = question;
	}

//	public void setChoices(ArrayList<String> choices) {
//		this.choices = choices;
//	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getQuestion() {
		return Question;
	}

//	public ArrayList<String> getChoices() {
//		return choices;
//	}

	public String getAnswer() {
		return answer;
	}

	public String getChoice_1() {
		return choice_1;
	}

	public void setChoice_1(String choice_1) {
		this.choice_1 = choice_1;
	}

	public String getChoice_2() {
		return choice_2;
	}

	public void setChoice_2(String choice_2) {
		this.choice_2 = choice_2;
	}

	public String getChoice_3() {
		return choice_3;
	}

	public void setChoice_3(String choice_3) {
		this.choice_3 = choice_3;
	}

	public String getChoice_4() {
		return choice_4;
	}

	public void setChoice_4(String choice_4) {
		this.choice_4 = choice_4;
	}

	@Override
	public String toString() {
		return "Question [Qid=" + Qid + ", Question=" + Question + ", choice_1=" + choice_1 + ", choice_2=" + choice_2
				+ ", choice_3=" + choice_3 + ", choice_4=" + choice_4 + ", answer=" + answer + "]";
	}

}
