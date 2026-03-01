package com.coronaconsultation.controller;

import java.util.List;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.coronaconsultation.entities.Employee;
import com.coronaconsultation.exception.EmployeeNotFoundException;
import com.coronaconsultation.services.EmployeeMasterImpl;

@RestController
public class HomeController {

    @Autowired
    private EmployeeMasterImpl employeeMasterImpl;

    @GetMapping("/")
    public String home(HttpSession session) {

        return "welcome " + session.getId();
    }

    @GetMapping("/home/employees")
    public ResponseEntity<List<Employee>> screenAllEmployees() {
        try {
            List<Employee> employees = employeeMasterImpl.getAllEmployees();
            if (employees != null && !employees.isEmpty()) {
                return new ResponseEntity<>(employees, HttpStatus.OK);
            }
        } catch (EmployeeNotFoundException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/home/employees/{id}")
    public ResponseEntity<Employee> screenEmployeeById(@PathVariable int id) {
        try {
            Employee employee = employeeMasterImpl.getEmployee(id);
            if (employee != null) {
                return new ResponseEntity<>(employee, HttpStatus.OK);
            }
        } catch (EmployeeNotFoundException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}