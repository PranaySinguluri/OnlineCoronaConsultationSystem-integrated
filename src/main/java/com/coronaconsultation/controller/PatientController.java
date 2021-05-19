package com.coronaconsultation.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coronaconsultation.entities.Doctor;
import com.coronaconsultation.entities.DoctorReport;
import com.coronaconsultation.entities.Patient;
import com.coronaconsultation.entities.PatientReport;
import com.coronaconsultation.entities.PatientRequests;
import com.coronaconsultation.services.PatientRequestServicesImpl;
import com.coronaconsultation.services.PatientServicesImpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/patient/")
public class PatientController {
	@Autowired
	PatientRequestServicesImpl patientRequestServicesImpl;
	@Autowired
	PatientServicesImpl patientServicesImpl;
	@PostMapping("/patientRegistration/")
	public ResponseEntity<String> createRequest(@RequestBody PatientRequests patientRequests){
		if(patientRequestServicesImpl.setNewRequest(patientRequests)) {
			return new ResponseEntity<>("Request Submitted!!",HttpStatus.CREATED);
		}
		return new ResponseEntity<>("Not Submitted!!",HttpStatus.BAD_REQUEST);
		
	}	
	
	
	@GetMapping("/getPatientById/{id}")
	public ResponseEntity<PatientRequests> getPatientRequest(@PathVariable int id){
		PatientRequests patientRequests= patientRequestServicesImpl.getPatientRequestById(id);
		if(patientRequests!=null) {
			return new ResponseEntity<>(patientRequests,HttpStatus.FOUND);
		}
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}	
	
	@GetMapping("/ViewPatientReport/{id}")
	public ResponseEntity<PatientReport> ViewPatientReport(@PathVariable int id){
		PatientReport patientReport= patientServicesImpl.ViewPatientReport(id);
		if(patientReport!=null) {
			return new ResponseEntity<>(patientReport,HttpStatus.FOUND);
		}
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/ViewDoctorReport/{id}")
	public ResponseEntity<DoctorReport> ViewDoctorReport(@PathVariable int id){
		DoctorReport doctorReport= patientServicesImpl.ViewDoctorReport(id);
		if(doctorReport!=null) {
			return new ResponseEntity<>(doctorReport,HttpStatus.FOUND);
		}
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}
	
	
	
	@GetMapping("/ViewTreatment/{id}")
	public ResponseEntity<String> ViewTreatment(@PathVariable int id){
		String treatment= patientServicesImpl.ViewTreatment(id);
		if(treatment!=null) {
			return new ResponseEntity<>(treatment,HttpStatus.FOUND);
		}
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/ViewDischargeSummary/{id}")
	public ResponseEntity<String> ViewDischargeSummmary(@PathVariable int id){
		String summary= patientServicesImpl.ViewDischargeSummary(id);
		if(summary!=null) {
			return new ResponseEntity<>(summary,HttpStatus.FOUND);
		}
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}
	
	
	
	
}
