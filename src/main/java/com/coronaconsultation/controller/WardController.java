package com.coronaconsultation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coronaconsultation.entities.Ward;
import com.coronaconsultation.exception.WardException;
import com.coronaconsultation.services.WardServiceImpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/ward/")
public class WardController {

	@Autowired
	private WardServiceImpl wardServiceImpl;
	
	@PostMapping("/")
	public boolean createWard(@RequestBody Ward ward) {
		
		wardServiceImpl.createWard(ward);
		return true;
	}
	
	@PostMapping("/v1/")
	public ResponseEntity<Boolean> createWardV1(@RequestBody Ward ward) {
		
		wardServiceImpl.createWard(ward);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public Ward findById(@PathVariable int id) throws WardException {
		Ward ward = wardServiceImpl.findById(id);
		return ward;
	}
	
	@GetMapping("/v1/{id}")
	public ResponseEntity<Ward> findByIdV1(@PathVariable int id) {
		Ward  ward = wardServiceImpl.findById(id);
		
		return new ResponseEntity<Ward>(ward, HttpStatus.OK);
	}
	
}