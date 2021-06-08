package com.coronaconsultation.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
