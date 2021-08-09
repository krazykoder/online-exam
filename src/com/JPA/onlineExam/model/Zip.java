package com.JPA.onlineExam.model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Embeddable
public class Zip {

	@Id
	private int zipID;

	@OneToOne
	private Topic topic;

	@OneToOne
	private Score score;

}