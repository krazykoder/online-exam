package com.JPA.onlineExam.entity;

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
	@Column(name = "ActId")
	private int ActId;

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

	private Date day;
	private String testlink;

	public int getActId() {
		return ActId;
	}

	public void setActId(int actId) {
		ActId = actId;
	}

	@Override
	public String toString() {
		return "DailyActivity [ActId=" + ActId + ", day=" + day + ", testlink=" + testlink + "]";
	}

	// collection of task

	// map with user

}
