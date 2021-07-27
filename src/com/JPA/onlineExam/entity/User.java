package com.JPA.onlineExam.entity;

import java.util.List;

import javax.persistence.CascadeType;
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

//	@ManyToMany
//	private List<MyTest> UnattemptTestSet;

	@OneToMany
	private List<AttemptedTest> atemptTestSet;

	// allows nullable
	@Nullable
	@ManyToMany(cascade = CascadeType.ALL)
	private List<User> friends;

	public User() {

	}

	public User(int user_id, String userName, String password) {
		super();
		this.user_id = user_id;
		this.userName = userName;
		this.password = password;
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

//	@ManyToMany
//	private List<DailyActivity> activity;
//
//	@ManyToMany
//	private List<Topics> topics;
//
//	@ElementCollection
//	private Map<Topics, Score> topicsScoreSet = new HashMap<Topics, Score>();
//
//	// @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE,
//	// CascadeType.DETACH, CascadeType.REFRESH })
//
}