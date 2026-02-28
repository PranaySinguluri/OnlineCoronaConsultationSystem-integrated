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
public class DepartmentReport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int dreport_id;
	private String dreport_name;
	private String dreport_Description;
	@OneToOne
	@JoinColumn(name = "department_id", nullable = true, referencedColumnName = "id")
	private Department department;

}
