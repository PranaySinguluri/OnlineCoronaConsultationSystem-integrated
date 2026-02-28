package com.coronaconsultation.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class DischargedPatients {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
@OneToOne
@JoinColumn(name = "patient_id", nullable = true ,referencedColumnName = "patientId")
private Patient patient;
private String DischargeSummary;
@OneToOne
@JoinColumn(name = "doctor_id", nullable = true ,referencedColumnName = "id")
private Doctor doctor;
}
