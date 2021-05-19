package com.coronaconsultation.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.coronaconsultation.entities.Doctor;
import com.coronaconsultation.entities.Employee;
import com.coronaconsultation.entities.Gender;
import com.coronaconsultation.exception.EmployeeNotFoundException;
import com.coronaconsultation.repository.EmployeeRepository;
@Service
public class EmployeeMasterImpl implements IEmployeeMaster {
@Autowired
private EmployeeRepository employeeRepository;

@Override
public boolean createEmployee(Employee employee) throws EmployeeNotFoundException {
	// TODO Auto-generated method stub
	if((employeeRepository.findById(employee.getId()).isEmpty())){
		employeeRepository.save(employee);
		return true;
	}
	else
	{
		throw new EmployeeNotFoundException("Employee Already exists!!");
		
	}
}

@Override
public boolean updateEmployee(int id, Employee employee) throws EmployeeNotFoundException {
	// TODO Auto-generated method stub
	Employee emp= employeeRepository.findById(id).get();
	if(emp!=null) {
		employeeRepository.save(employee);
		return true;
	}
	else {
		throw new EmployeeNotFoundException("Employee Not Found!!");
	}
}

@Override
public boolean deleteEmployee(int id) throws EmployeeNotFoundException {
	// TODO Auto-generated method stub
	Employee emp= employeeRepository.findById(id).get();
	if(emp!=null) {
		employeeRepository.delete(emp);
		return true;
	}
	else {
		throw new EmployeeNotFoundException("Employee Not Found!!");
	}
}

@Override
public Employee getEmployee(int id) throws EmployeeNotFoundException {
	// TODO Auto-generated method stub
	Employee employee= employeeRepository.findById(id).get();
	if(employee!= null) {
		return employee;
	}
	else {
		throw new EmployeeNotFoundException("Employee Not Found!!");
	}
}

@Override
public List<Employee> getAllEmployees() throws EmployeeNotFoundException {
	// TODO Auto-generated method stub
	if(employeeRepository.findAll().isEmpty()) {
			throw new EmployeeNotFoundException("Employee Not Found!!");
	}
	return employeeRepository.findAll();
}

@Override
public boolean updateName(int id, String name) throws EmployeeNotFoundException {
	// TODO Auto-generated method stub
	Employee employee = employeeRepository.findById(id).get();
	
	if(employee!=null) {
		employee.setName(name);
		return true;
	}
	else {
		throw new EmployeeNotFoundException("Employee Not Found!!");
	}
}

@Override
public boolean updateGender(int id, Gender gender) throws EmployeeNotFoundException {
	// TODO Auto-generated method stub
Employee employee = employeeRepository.findById(id).get();

	
	if(employee!=null) {
		employee.setGender(gender);
		return true;
	}
	else {
		throw new EmployeeNotFoundException("Employee Not Found!!");
	}
}

@Override
public boolean updateAddress(int id, String Address) throws EmployeeNotFoundException {
	// TODO Auto-generated method stub
Employee employee = employeeRepository.findById(id).get();
	
	if(employee!=null) {
		employee.setAddress(Address);
		return true;
	}
	else {
		throw new EmployeeNotFoundException("Employee Not Found!!");
	}
}

@Override
public boolean updateEmail(int id, String email) throws EmployeeNotFoundException {
	// TODO Auto-generated method stub
Employee employee = employeeRepository.findById(id).get();
	
	if(employee!=null) {
		employee.setEmail(email);
		return true;
	}
	else {
		throw new EmployeeNotFoundException("Employee Not Found!!");
	}
}

@Override
public boolean updateMobile(int id, String mobile) throws EmployeeNotFoundException {
	// TODO Auto-generated method stub
Employee employee = employeeRepository.findById(id).get();
	
	if(employee!=null) {
		employee.setMobile(mobile);
		return true;
	}
	else {
		throw new EmployeeNotFoundException("Employee Not Found!!");
	}
}

@Override
public boolean updateDesignation(int id, String designation) throws EmployeeNotFoundException {
	// TODO Auto-generated method stub
	Employee employee = employeeRepository.findById(id).get();
	if(employee!=null) {
		employee.setDesignation(designation);
		return true;
	}
	else {
		throw new EmployeeNotFoundException("Employee Not Found!!");
	}
}

}
