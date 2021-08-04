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
	@Column(name = "Id")
	private int Id;

	@Column(name = "userName")
	private String userName;

	@Column(name = "password")
	private String password;

	@ManyToMany
	private List<TestPaper> TestPaperList;

	@OneToMany
	private List<AttemptedTest> attemptTestPaperList;

	// allows nullable
	@Nullable
	@ManyToMany
	private List<User> friends;

	@OneToMany
	private List<DailyActivity> activity;

	@OneToMany
	private List<TopicWiseScore> TopicWiseScoreList;

	public List<TopicWiseScore> getScoreTopic() {
		return TopicWiseScoreList;
	}

	public void setScoreTopic(List<TopicWiseScore> TopicWiseScoreList) {
		this.TopicWiseScoreList = TopicWiseScoreList;
	}

	public List<DailyActivity> getActivity() {
		return activity;
	}

	public void setActivity(List<DailyActivity> activity) {
		this.activity = activity;
	}

	public int getId() {
		return Id;
	}

	public void setId(int Id) {
		this.Id = Id;
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

	public List<AttemptedTest> getattemptTestPaperList() {
		return attemptTestPaperList;
	}

	public void setattemptTestPaperList(List<AttemptedTest> attemptTestPaperList) {
		this.attemptTestPaperList = attemptTestPaperList;
	}

	public List<User> getFriends() {
		return friends;
	}

	public void setFriends(List<User> friends) {
		this.friends = friends;
	}

	public List<TestPaper> getTestPaperList() {
		return TestPaperList;
	}

	public void setTestPaperList(List<TestPaper> TestPaperList) {
		this.TestPaperList = TestPaperList;
	}

	@Override
	public String toString() {
		return "User [user_id=" + Id + ", userName=" + userName + ", password=" + password + ", TestPaperList="
				+ TestPaperList + ", attemptTestPaperList=" + attemptTestPaperList + ", friends=" + friends
				+ ", activity=" + activity + ", TopicWiseScoreList=" + TopicWiseScoreList + "]";
	}

}
