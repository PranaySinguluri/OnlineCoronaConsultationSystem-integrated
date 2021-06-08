package com.coronaconsultation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coronaconsultation.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
