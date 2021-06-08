package com.coronaconsultation.entities;

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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Integer.class)
public class Treatment {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
@ManyToOne
@JoinColumn(name = "doctor_id", nullable = true ,referencedColumnName = "id")
private Doctor doctor;
private String treatement;
@ManyToOne
@JoinColumn(name = "patient_id", nullable = true ,referencedColumnName = "patientId")
private Patient patient;
}
