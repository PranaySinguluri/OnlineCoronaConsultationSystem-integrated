package com.coronaconsultation.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.coronaconsultation.entities.Doctor;
import com.coronaconsultation.entities.Employee;
import com.coronaconsultation.entities.Gender;
import com.coronaconsultation.repository.EmployeeRepository;
@Service
public class EmployeeMasterImpl implements IEmployeeMaster {
@Autowired
private EmployeeRepository employeeRepository;

@Override
public boolean createEmployee(Employee employee) {
	// TODO Auto-generated method stub
	if(employeeRepository.findById(employee.getId()).isEmpty()) {

		employeeRepository.save(employee);
		return true;
	}
	return false;
}

@Override
public boolean updateEmployee(int id, Employee employee) {
	// TODO Auto-generated method stub
	Employee emp= employeeRepository.findById(id).get();
	if(emp!=null) {
		employeeRepository.save(employee);
		return true;
	}
	return false;
}

@Override
public boolean deleteEmployee(int id) {
	// TODO Auto-generated method stub
	Employee emp= employeeRepository.findById(id).get();
	if(emp!=null) {
		employeeRepository.delete(emp);
		return true;
	}
	return false;
}

@Override
public Employee getEmployee(int id) {
	// TODO Auto-generated method stub
	Employee employee= employeeRepository.findById(id).get();
	if(employee!= null) {
		return employee;
	}
	return null;
}

@Override
public List<Employee> getAllEmployees() {
	// TODO Auto-generated method stub
	return employeeRepository.findAll();
}

@Override
public boolean updateName(int id, String name) {
	// TODO Auto-generated method stub
	Employee employee = employeeRepository.findById(id).get();
	
	if(employee!=null) {
		employee.setName(name);
		return true;
	}
	return false;
}

@Override
public boolean updateGender(int id, Gender gender) {
	// TODO Auto-generated method stub
Employee employee = employeeRepository.findById(id).get();
	
	if(employee!=null) {
		employee.setGender(gender);
		return true;
	}
	return false;
}

@Override
public boolean updateAddress(int id, String Address) {
	// TODO Auto-generated method stub
Employee employee = employeeRepository.findById(id).get();
	
	if(employee!=null) {
		employee.setAddress(Address);
		return true;
	}
	return false;
}

@Override
public boolean updateEmail(int id, String email) {
	// TODO Auto-generated method stub
Employee employee = employeeRepository.findById(id).get();
	
	if(employee!=null) {
		employee.setEmail(email);
		return true;
	}
	return false;
}

@Override
public boolean updateMobile(int id, String mobile) {
	// TODO Auto-generated method stub
Employee employee = employeeRepository.findById(id).get();
	
	if(employee!=null) {
		employee.setMobile(mobile);
		return true;
	}
	return false;
}

@Override
public boolean updateDesignation(int id, String designation) {
	// TODO Auto-generated method stub
Employee employee = employeeRepository.findById(id).get();
	
	if(employee!=null) {
		employee.setDesignation(designation);
		return true;
	}
	return false;
}

}
