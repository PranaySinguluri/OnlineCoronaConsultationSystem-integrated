package com.coronaconsultation.services;

import java.util.List;

import com.coronaconsultation.entities.Department;

public interface IDepartmentMaster {
	public boolean createDepartment(Department department);
	public List<Department> GetAll();
	public Department GetById(int id);
	public boolean DeleteDepartment(int id);
	

}
