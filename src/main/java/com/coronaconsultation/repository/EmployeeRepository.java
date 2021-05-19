package com.coronaconsultation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coronaconsultation.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
