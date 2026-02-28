package com.coronaconsultation.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class DoctorReport {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int docReportId;
@Column(name = "description", length = 15)
private String description;

@Column(name = "dateOfReport", nullable = true)
private LocalDate dateOfReport;


@OneToOne
@JoinColumn(name = "patient_id",  nullable = true, referencedColumnName = "patientId")
private Patient patient;
@ManyToOne
@JoinColumn(name = "doctor_id",  nullable = true, referencedColumnName = "id")
private Doctor doctor;
}
