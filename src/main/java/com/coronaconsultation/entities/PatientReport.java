package com.coronaconsultation.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

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
	private ServiceType serviceType;
	private Boolean condition;
	

		
		@OneToOne
		@JoinColumn(name = "patient_id", nullable = true ,referencedColumnName = "patientId")
		  private Patient patient;
		 @OneToOne
		 @JoinColumn(name = "doctor_id",nullable = true, referencedColumnName = "id")
		 private Doctor doctor; 
		 @OneToOne
		 @JoinColumn(name = "room_no",nullable = true, referencedColumnName = "room_no")
		 private Room room;
		 private String description;
		
		 @OneToOne
		 @JoinColumn(name = "medical_report_id",nullable = true, referencedColumnName = "id")
		 private MedicineReport medicalReport;	
	
	

	 
}
