package com.coronaconsultation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coronaconsultation.entities.Department;
import com.coronaconsultation.services.IDepartmentMaster;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/Department/")
@CrossOrigin
public class DepartmentController {
	@Autowired
	private IDepartmentMaster departmentMaster;

	@PostMapping("/")
	ResponseEntity<String> CreateDepartment(@RequestBody Department department) {
		if (department != null) {
			if (departmentMaster.createDepartment(department)) {
				return new ResponseEntity<>("Department Created!!", HttpStatus.OK);
			}

		}
		return new ResponseEntity<>("Failed to create a new department!!", HttpStatus.BAD_REQUEST);

	}

	@GetMapping("/{id}/")
	public ResponseEntity<Department> getDepartment(@PathVariable int id) {
		Department department = departmentMaster.GetById(id);
		if (department != null) {
			return new ResponseEntity<>(department, HttpStatus.OK);
		}

		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@GetMapping("/GetAll/")
	public ResponseEntity<List<Department>> getAllDepartment() {
		List<Department> departments = departmentMaster.GetAll();
		if (departments.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(departments, HttpStatus.OK);

	}

}
