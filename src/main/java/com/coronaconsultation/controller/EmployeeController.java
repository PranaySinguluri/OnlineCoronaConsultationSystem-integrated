package com.coronaconsultation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coronaconsultation.entities.Doctor;
import com.coronaconsultation.entities.Employee;
import com.coronaconsultation.entities.Gender;
import com.coronaconsultation.services.EmployeeMasterImpl;

@RestController
@RequestMapping("/api/employee/")
public class EmployeeController {
	@Autowired
	private EmployeeMasterImpl employeeMasterImpl;
	@PostMapping("/")
public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
		
		employeeMasterImpl.createEmployee(employee);
		return new ResponseEntity<>("Employee Created", HttpStatus.OK);
	}
	
	
	@PutMapping("/updateEmployee/updateAllFields/{id}/")
	public ResponseEntity<String> updateEmployee(@PathVariable int id, @RequestBody Employee employee){
		if(employeeMasterImpl.updateEmployee(id, employee)) {
			return new ResponseEntity<>("Employee Updated!!", HttpStatus.OK);
		}
		return new ResponseEntity<>("No such id Exists!!", HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/updateEmployee/updateName/{id}/")
	public ResponseEntity<String> updateEmployeeName(@PathVariable int id, @RequestBody String name){
		
		System.out.println("Name Was:: "+name);
		if(employeeMasterImpl.updateName(id, name)) {
			return new ResponseEntity<>("Name Updated!!", HttpStatus.OK);
		}
		return new ResponseEntity<>("No such id Exists!!", HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/updateEmployee/updateEmail/{id}/")
	public ResponseEntity<String> updateEmployeeEmail(@PathVariable int id, @RequestBody String email){
		if(employeeMasterImpl.updateEmail(id, email)) {
			return new ResponseEntity<>("Email Updated!!", HttpStatus.OK);
		}
		return new ResponseEntity<>("No such id Exists!!", HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/updateEmployee/updateMobile/{id}/")
	public ResponseEntity<String> updateDoctorMobile(@PathVariable int id, @RequestBody String mobile){
		if(employeeMasterImpl.updateMobile(id, mobile)) {
			return new ResponseEntity<>("Mobile Updated!!", HttpStatus.OK);
		}
		return new ResponseEntity<>("No such id Exists!!", HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/updateEmployee/updateGender/{id}/")
	public ResponseEntity<String> updateDoctorGender(@PathVariable int id, @RequestBody Gender gender){
		if(employeeMasterImpl.updateGender(id, gender)) {
			return new ResponseEntity<>("Gender Updated!!", HttpStatus.OK);
		}
		return new ResponseEntity<>("No such id Exists!!", HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/updateEmployee/updateDesignation/{id}/")
	public ResponseEntity<String> updateDoctorSpecialization(@PathVariable int id, @RequestBody String designation){
		if(employeeMasterImpl.updateDesignation(id, designation)) {
			return new ResponseEntity<>("Designation Updated!!", HttpStatus.OK);
		}
		return new ResponseEntity<>("No such id Exists!!", HttpStatus.NOT_FOUND);
	}
	@PutMapping("/updateAddress/updateAddress/{id}/")
	public ResponseEntity<String> updateEmployeeAddress(@PathVariable int id, @RequestBody String address){
		if(employeeMasterImpl.updateAddress(id, address)) {
			return new ResponseEntity<>("Email Updated!!", HttpStatus.OK);
		}
		return new ResponseEntity<>("No such id Exists!!", HttpStatus.NOT_FOUND);
	}
	
	
	
	@DeleteMapping("/delete/{id}/")
	public ResponseEntity<String> deleteEmployee(@PathVariable int id){
		if(employeeMasterImpl.deleteEmployee(id)) {
			return new ResponseEntity<String>("Employee deleted !!", HttpStatus.OK);
		}
		return new ResponseEntity<>("No such id Exists!!", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/{id}/")
	public ResponseEntity<Employee> getEmployee(@PathVariable int id){
		Employee employee= employeeMasterImpl.getEmployee(id);
		if(employee!=null) {
			return new ResponseEntity<>(employee, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/allEmployees")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> employees = employeeMasterImpl.getAllEmployees();
		if(employees!=null) {
			return new ResponseEntity<>(employees, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	

}
