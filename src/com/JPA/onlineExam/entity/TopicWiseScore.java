package com.JPA.onlineExam.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TopicWiseScore")
public class TopicWiseScore {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;

	@OneToOne
	private Topic topic;

	@OneToOne
	private Score score;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

}
