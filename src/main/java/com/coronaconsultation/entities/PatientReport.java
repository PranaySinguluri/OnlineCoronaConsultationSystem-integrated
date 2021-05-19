package com.coronaconsultation.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Integer.class)
public class PatientReport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int patientReportId;
	private ServiceType servicetype;
	private Boolean Condition;
	

		
		@OneToOne
		  private Patient patient;
		 @OneToOne
		 private Doctor doctor; 
		 @OneToOne
		 private Room room;
		 private String description;
		
		 @OneToOne
		 private MedicalReport medicalReport;	
	
	

	 
}
