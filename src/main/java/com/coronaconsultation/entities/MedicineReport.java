package com.coronaconsultation.entities;
import java.time.LocalDate;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "medicineReportId", scope = Integer.class)
public class MedicineReport {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique= true)
	private  Integer  medicineReportId;
	
	private LocalDate reportdate;
	private String description;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "patient_id", referencedColumnName = "patientId")
	private Patient patient;
	
	@ManyToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name = "id")
	private Medicine medicine;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "doctor_id", referencedColumnName = "id")
	private Doctor doc;
}
 


