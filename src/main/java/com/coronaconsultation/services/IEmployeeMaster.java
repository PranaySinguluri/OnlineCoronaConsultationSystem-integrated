package com.coronaconsultation.services;

import java.util.List;

import com.coronaconsultation.entities.Doctor;
import com.coronaconsultation.entities.Employee;
import com.coronaconsultation.entities.Gender;
import com.coronaconsultation.exception.EmployeeNotFoundException;

public interface IEmployeeMaster {
	public boolean createEmployee(Employee employee) throws EmployeeNotFoundException;
	public boolean updateEmployee(int id, Employee employee) throws EmployeeNotFoundException;
	public boolean deleteEmployee(int id) throws EmployeeNotFoundException;
	public Employee getEmployee(int id) throws EmployeeNotFoundException;
	public List<Employee> getAllEmployees() throws EmployeeNotFoundException;
	public boolean updateName(int id,String name) throws EmployeeNotFoundException;
	public boolean updateGender(int id,Gender gender) throws EmployeeNotFoundException;
	public boolean updateAddress(int id, String Address) throws EmployeeNotFoundException;
	public boolean updateEmail(int id,String email) throws EmployeeNotFoundException;
	public boolean updateMobile(int id,String mobile) throws EmployeeNotFoundException;
	public boolean updateDesignation(int id,String designation) throws EmployeeNotFoundException;
	
}
