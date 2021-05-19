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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coronaconsultation.entities.Doctor;
import com.coronaconsultation.entities.Gender;
import com.coronaconsultation.services.DoctorMasterImpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
@RestController
@RequestMapping("api/doctor/")
public class DoctorController {
	@Autowired
	private DoctorMasterImpl doctorMasterImpl;
	@PostMapping("/")
	public ResponseEntity<String> createDoctor(@RequestBody Doctor doctor){
		doctorMasterImpl.createDoctor(doctor);
		return new ResponseEntity<>("Doctor Created!!",HttpStatus.OK);
		
	}
	
	@PutMapping("/updateDoctor/updateAllFields/{id}/")
	public ResponseEntity<String> updateDoctor(@PathVariable int id, @RequestBody Doctor doctor){
		if(doctorMasterImpl.updateDoctor(id, doctor)) {
			return new ResponseEntity<>("Doctor Updated!!", HttpStatus.OK);
		}
		return new ResponseEntity<>("No such id Exists!!", HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/updateDoctor/updateName/{id}/")
	public ResponseEntity<String> updateDoctorName(@PathVariable int id, @RequestBody String name){
		
		System.out.println("Name Was:: "+name);
		if(doctorMasterImpl.updateName(id, name)) {
			return new ResponseEntity<>("Name Updated!!", HttpStatus.OK);
		}
		return new ResponseEntity<>("No such id Exists!!", HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/updateDoctor/updateEmail/{id}/")
	public ResponseEntity<String> updateDoctorEmail(@PathVariable int id, @RequestBody String email){
		if(doctorMasterImpl.updateEmail(id, email)) {
			return new ResponseEntity<>("Email Updated!!", HttpStatus.OK);
		}
		return new ResponseEntity<>("No such id Exists!!", HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/updateDoctor/updateMobile/{id}/")
	public ResponseEntity<String> updateDoctorMobile(@PathVariable int id, @RequestBody String mobile){
		if(doctorMasterImpl.updateMobile(id, mobile)) {
			return new ResponseEntity<>("Mobile Updated!!", HttpStatus.OK);
		}
		return new ResponseEntity<>("No such id Exists!!", HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/updateDoctor/updateGender/{id}/")
	public ResponseEntity<String> updateDoctorGender(@PathVariable int id, @RequestBody Gender gender){
		if(doctorMasterImpl.updateGender(id, gender)) {
			return new ResponseEntity<>("Gender Updated!!", HttpStatus.OK);
		}
		return new ResponseEntity<>("No such id Exists!!", HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/updateDoctor/updateSpecialization/{id}/")
	public ResponseEntity<String> updateDoctorSpecialization(@PathVariable int id, @RequestBody String specialization){
		if(doctorMasterImpl.updateSpecialization(id, specialization)) {
			return new ResponseEntity<>("Specialization Updated!!", HttpStatus.OK);
		}
		return new ResponseEntity<>("No such id Exists!!", HttpStatus.NOT_FOUND);
	}
	
	
	
	
	@DeleteMapping("/{id}/")
	public ResponseEntity<String> deleteDoctor(@PathVariable int id){
		if(doctorMasterImpl.deleteDoctor(id)) {
			return new ResponseEntity<String>("Doctor deleted !!", HttpStatus.OK);
		}
		return new ResponseEntity<>("No such id Exists!!", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/{id}/")
	public ResponseEntity<Doctor> getDoctor(@PathVariable int id){
		Doctor doc =doctorMasterImpl.getDoctor(id);
		if(doc!=null) {
			return new ResponseEntity<>(doc, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/allDoctors")
	public ResponseEntity<List<Doctor>> getAllDoctors(){
		List<Doctor> doc = doctorMasterImpl.getAllDoctors();
		if(doc!=null) {
			return new ResponseEntity<>(doc, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	

}
