package com.coronaconsultation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coronaconsultation.entities.ServiceType;
import com.coronaconsultation.entities.Services;
import com.coronaconsultation.services.ServiceMasterImpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

//enum ServiceType{IPD,OPD}

@RestController
@RequestMapping("/api/services/")
public class ServicesController {
	@Autowired
	ServiceMasterImpl serviceMasterImpl;
	@PostMapping("/")
	public ResponseEntity<String> AddNewServices(@RequestBody Services services){
		if(services.isCondition()) {
			services.setServiceType(ServiceType.IPD);
		}
		else {
			services.setServiceType(ServiceType.OPD);
		}
		serviceMasterImpl.AddService(services);
		return new ResponseEntity<>("Service Added",HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}/")
	public ResponseEntity<Services> GetServicesData(@RequestBody int id){
		Services ser= serviceMasterImpl.GetService(id);
		return new ResponseEntity<>(ser,HttpStatus.OK);
	}

}
