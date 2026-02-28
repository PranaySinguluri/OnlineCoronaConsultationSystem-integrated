package com.coronaconsultation.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Data;

@Entity
@Data
public class PatientRequests {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer patientid;
	private String name;
	private String email;
	private Gender gender;
	private String mobile;
	private String Location;
	private ServiceType serviceType;
}
