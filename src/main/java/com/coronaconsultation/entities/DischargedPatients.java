package com.coronaconsultation.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

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
