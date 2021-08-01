
package com.JPA.onlineExam.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Score")
public class Score {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ScoreId")
	private int ScoreId;

	private int score;
	private int percentile;

	public int getScoreId() {
		return ScoreId;
	}

	public void setScoreId(int scoreId) {
		ScoreId = scoreId;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getPercentile() {
		return percentile;
	}

	public void setPercentile(int percentile) {
		this.percentile = percentile;
	}

	@Override
	public String toString() {
		return "Score [ScoreId=" + ScoreId + ", score=" + score + ", percentile=" + percentile + "]";
	}

}
