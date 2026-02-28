package com.coronaconsultation.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "patientId", scope = Integer.class)
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer patientId;
	private String name;
	private String email;
	private Gender gender;
	private String mobile;
	private String location;
	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Treatment> treatement;
	@OneToOne(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	// @JoinTable(name = "patients_services", joinColumns = {
	// @JoinColumn(name = "patient_id", nullable = true, referencedColumnName =
	// "patientid") }, inverseJoinColumns = {
	// @JoinColumn(name = "service_id", nullable = true, referencedColumnName =
	// "id") })
	private Services service;

	@OneToOne(mappedBy = "patient", optional = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	// @JoinTable(name = "patients_reports", joinColumns = {
	// @JoinColumn(name = "patient_id", nullable = true, referencedColumnName =
	// "patientid") }, inverseJoinColumns = {
	// @JoinColumn(name = "patientReportId", nullable = true, referencedColumnName =
	// "patientReportId") })
	private PatientReport patientReport;

	@OneToOne(mappedBy = "patient", optional = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	// @JoinTable(name = "patients_doctor_reports", joinColumns = {
	// @JoinColumn(name = "patient_id", nullable = true, referencedColumnName =
	// "patientid") }, inverseJoinColumns = {
	// @JoinColumn(name = "doctorReportId", nullable = true, referencedColumnName =
	// "docReportId") })
	private DoctorReport doctorReport;
	@OneToOne(mappedBy = "patient", optional = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	// @JoinColumn(name = "billing_id", referencedColumnName = "id")
	private Bills bills;
	@OneToOne(mappedBy = "patient", optional = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	// @JoinTable(name = "patients_feedbacks", joinColumns = {
	// @JoinColumn(name = "patient_id", nullable = true, referencedColumnName =
	// "patientid") }, inverseJoinColumns = {
	// @JoinColumn(name = "feedbackId", nullable = true, referencedColumnName =
	// "id") })
	// @JoinColumn(name = "feedbackId", referencedColumnName = "id")
	private Feedback feedback;

}