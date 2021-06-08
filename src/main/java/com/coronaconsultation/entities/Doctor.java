package com.coronaconsultation.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Entity
@Data
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "Doctor_Name")
	@NotNull(message = "Name Should Not be Null")
	private String name;
	
	@Column(nullable= false)
	private String specialization;
	
	@Column(name = "email")
	@NotNull(message = "Doctor Mail is Compulsory")
	@Email
	private String email;
	
	
	@Column(name = "Mobile_Number")
	@Pattern(regexp = "^[6-9][0-9]{9}+$", message = "Enter Valid Mobile Number")
	private String mobile;
	
	@Column(nullable= false)
	private Gender gender;
	@OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Treatment> treatement;
	@OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<PatientReport> patientReport;
	@OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<DoctorReport> doctorReport;
	
}
