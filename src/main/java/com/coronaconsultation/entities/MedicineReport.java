package com.coronaconsultation.entities;
import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "medicineReportId", scope = Integer.class)
public class MedicineReport {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique= true)
	private  Integer  medicineReportId;
	
	@Column(name = "reportDate", length = 15)
	@NotNull(message = "Date Of Report should not be Empty")
	private LocalDate reportDate;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "patientId")
	@Min(1)
	private Patient patient;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "medicineId")
	@Min(1)
	private Medicine medicine;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Id")
	@Min(1)
	private Doctor doc;
}