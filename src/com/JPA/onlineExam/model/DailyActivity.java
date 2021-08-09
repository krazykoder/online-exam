package com.JPA.onlineExam.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DailyActivity")
public class DailyActivity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int Id;
	private Date day;
	private String testlink;

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	public String getTestlink() {
		return testlink;
	}

	public void setTestlink(String testlink) {
		this.testlink = testlink;
	}

	public int getId() {
		return Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}

	@Override
	public String toString() {
		return "DailyActivity [Id=" + Id + ", day=" + day + ", testlink=" + testlink + "]";
	}

	// collection of task

	// map with user

}
