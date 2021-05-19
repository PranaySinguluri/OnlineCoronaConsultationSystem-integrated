package com.coronaconsultation.services;

import java.util.List;

import com.coronaconsultation.entities.Doctor;
import com.coronaconsultation.entities.Employee;
import com.coronaconsultation.entities.Gender;

public interface IEmployeeMaster {
	public boolean createEmployee(Employee employee);
	public boolean updateEmployee(int id, Employee employee);
	public boolean deleteEmployee(int id);
	public Employee getEmployee(int id);
	public List<Employee> getAllEmployees();
	public boolean updateName(int id,String name);
	public boolean updateGender(int id,Gender gender);
	public boolean updateAddress(int id, String Address);
	public boolean updateEmail(int id,String email);
	public boolean updateMobile(int id,String mobile);
	public boolean updateDesignation(int id,String designation);
	
}
