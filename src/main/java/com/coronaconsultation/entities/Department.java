package com.coronaconsultation.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Integer.class)
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	@OneToMany(mappedBy = "department")
	private List<Employee> employee;
	@OneToOne(mappedBy = "department", cascade = CascadeType.ALL)
	@JoinTable(name = "each_department_reports", joinColumns = {
			@JoinColumn(name = "department_id", nullable = true, referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "department_report_id", nullable = true, referencedColumnName = "dreport_id") })
	private DepartmentReport departmentReport;
	

}