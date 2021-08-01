package com.JPA.onlineExam.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.Nullable;

@Entity
@Table(name = "User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int user_id;

	@Column(name = "userName")
	private String userName;

	@Column(name = "password")
	private String password;

	@ManyToMany
	private List<TestPaper> TestPaperSet;

	@OneToMany
	private List<AttemptedTest> atemptTestSet;

	// allows nullable
	@Nullable
	@ManyToMany
	private List<User> friends;

	@OneToMany
	private List<DailyActivity> activity;

	@OneToMany
	private List<TopicWiseScore> scoreTopic;

	public List<TestPaper> getTestPaperSet() {
		return TestPaperSet;
	}

	public void setTestPaperSet(List<TestPaper> testPaperSet) {
		TestPaperSet = testPaperSet;
	}

	public List<TopicWiseScore> getScoreTopic() {
		return scoreTopic;
	}

	public void setScoreTopic(List<TopicWiseScore> scoreTopic) {
		this.scoreTopic = scoreTopic;
	}

	public List<DailyActivity> getActivity() {
		return activity;
	}

	public void setActivity(List<DailyActivity> activity) {
		this.activity = activity;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<AttemptedTest> getAtemptTestSet() {
		return atemptTestSet;
	}

	public void setAtemptTestSet(List<AttemptedTest> atemptTestSet) {
		this.atemptTestSet = atemptTestSet;
	}

	public List<User> getFriends() {
		return friends;
	}

	public void setFriends(List<User> friends) {
		this.friends = friends;
	}

	public List<TestPaper> getUnattemptTestSet() {
		return TestPaperSet;
	}

	public void setUnattemptTestSet(List<TestPaper> unattemptTestSet) {
		TestPaperSet = unattemptTestSet;
	}

//	@Override
//	public String toString() {
//		return "User [user_id=" + user_id + ", userName=" + userName + ", password=" + password + ", TestPaperSet="
//				+ TestPaperSet + ", atemptTestSet=" + atemptTestSet + ", friends=" + friends + ", activity=" + activity
//				+ ", topicsScoreSet=" + topicsScoreSet + "]";
//	}

}
