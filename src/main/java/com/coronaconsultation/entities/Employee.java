package com.coronaconsultation.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

//import com.capgemini.entities.Department;

import lombok.Data;
@Entity
@Data 
public class Employee {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String name;
private String designation;
private String email;
private String mobile;
private Gender gender;
private String address;
@ManyToOne
@JoinColumn(name = "department_id", nullable = true, referencedColumnName = "id")
private Department department;
}
