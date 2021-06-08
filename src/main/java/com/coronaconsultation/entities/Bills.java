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
