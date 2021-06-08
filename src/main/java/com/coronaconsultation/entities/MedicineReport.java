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
public class MedicalReport {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
@OneToOne
@JoinColumn(name = "patient_id", referencedColumnName = "patientId")
private Patient patient;
@OneToOne
@JoinColumn(name = "doctor_id", referencedColumnName = "id")
private Doctor doctor;

}
