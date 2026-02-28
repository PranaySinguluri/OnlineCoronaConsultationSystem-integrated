package com.coronaconsultation.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

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
