package com.coronaconsultation.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Integer.class)
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer patientid;
	private String name;
	@Column(nullable = true)
	private String email;
	@Column(nullable = true)
	private Gender gender;
	@Column(nullable = true)
	private String mobile;
	@Column(nullable = true)
	private String Location;
	@Column(nullable = true)
	private String treatment;
	@OneToOne(mappedBy = "patient", cascade = CascadeType.ALL)
	@JoinTable(name = "patients_services", joinColumns = {
			@JoinColumn(name = "patient_id", nullable = true, referencedColumnName = "patientid") }, inverseJoinColumns = {
					@JoinColumn(name = "service_id", nullable = true, referencedColumnName = "id") })
	private Services service;

	@OneToOne(mappedBy = "patient", cascade = CascadeType.ALL)
	@JoinTable(name = "patients_reports", joinColumns = {
			@JoinColumn(name = "patient_id", nullable = true, referencedColumnName = "patientid") }, inverseJoinColumns = {
					@JoinColumn(name = "patientReportId", nullable = true, referencedColumnName = "patientReportId") })
	private PatientReport patientReport;

	@OneToOne(mappedBy = "patient", cascade = CascadeType.ALL)
	@JoinTable(name = "patients_doctor_reports", joinColumns = {
			@JoinColumn(name = "patient_id", nullable = true, referencedColumnName = "patientid") }, inverseJoinColumns = {
					@JoinColumn(name = "doctorReportId", nullable = true, referencedColumnName = "docReportId") })
	private DoctorReport doctorReport;
	/*
	 * @OneToOne
	 * 
	 * @JoinColumn(name = "billingId", referencedColumnName = "billing_Id" private
	 * Billing billing;
	 */
	@OneToOne(mappedBy = "patient", cascade = CascadeType.ALL)
	@JoinTable(name = "patients_feedbacks",  joinColumns = {
			@JoinColumn(name = "patient_id", nullable = true, referencedColumnName = "patientid") }, inverseJoinColumns = {
					@JoinColumn(name = "feedbackId", nullable = true, referencedColumnName = "id") })
	@JoinColumn(name = "feedbackId", referencedColumnName = "id")
	private Feedback feedback;

}