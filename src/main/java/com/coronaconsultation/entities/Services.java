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
public class Services {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int id;
	@OneToOne
	@JoinColumn(name = "patient_id", referencedColumnName = "patientId")
	private Patient patient;
	private Boolean IPD;
	private Boolean OPD;
	private String additionalServices;
	
	

}
