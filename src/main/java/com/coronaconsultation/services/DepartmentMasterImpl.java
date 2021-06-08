package com.coronaconsultation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coronaconsultation.entities.Department;
import com.coronaconsultation.repository.DepartmentRepository;
@Service
public class DepartmentMasterImpl implements IDepartmentMaster {
	@Autowired
	private DepartmentRepository departmentRepository;
	@Override
	public boolean createDepartment(Department department) {
		// TODO Auto-generated method stub
		if(departmentRepository.save(department) != null) {
			return true;
		}
		return false;
	}

	@Override
	public List<Department> GetAll() {
		// TODO Auto-generated method stub
		List<Department> departments= departmentRepository.findAll();
		if(departments.isEmpty()) {
			return null;
		}
		else{
			return departments;
		}
	}

	@Override
	public Department GetById(int id) {
		// TODO Auto-generated method stub
		Department department= departmentRepository.findById(id).get();
		if(department!=null) {
			return department;
		}
		return null;
	}

	@Override
	public boolean DeleteDepartment(int id) {
		// TODO Auto-generated method stub
		if(departmentRepository.existsById(id)) {
			departmentRepository.deleteById(id);
			return true;
		}
		
		return false;
	}

}
