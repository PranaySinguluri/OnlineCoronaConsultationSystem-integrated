package com.coronaconsultation.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int docRating;
	private int  serviceRating;
	@OneToOne
	@JoinColumn(name = "patient_id", referencedColumnName = "patientId")
	private Patient patient;
	
}
