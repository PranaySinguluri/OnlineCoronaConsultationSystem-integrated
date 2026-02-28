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
public class Bills {
@Id
@GeneratedValue(strategy =  GenerationType.IDENTITY)
private int id;
private String Pname;
private Float Total;
@OneToOne
@JoinColumn(name = "patient_id", referencedColumnName = "patientId")
private Patient patient;

}
