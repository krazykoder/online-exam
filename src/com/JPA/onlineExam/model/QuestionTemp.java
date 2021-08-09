package com.JPA.onlineExam.model;

public class QuestionTemp {

	private int Qid;
	private String Question;
	private String choice_1;
	private String choice_2;
	private String choice_3;
	private String choice_4;
	private String answer;

	private TestPaper test;

	public int getQid() {
		return Qid;
	}

	public void setQid(int qid) {
		Qid = qid;
	}

	public String getQuestion() {
		return Question;
	}

	public void setQuestion(String question) {
		this.Question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public TestPaper getTest() {
		return test;
	}

	public void setTest(TestPaper test) {
		this.test = test;
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

}
