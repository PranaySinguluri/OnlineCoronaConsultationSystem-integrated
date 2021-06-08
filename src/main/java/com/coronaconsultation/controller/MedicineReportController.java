package com.coronaconsultation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coronaconsultation.entities.MedicineReport;
import com.coronaconsultation.repository.MedicineReportRepo;

@RestController
@RequestMapping(value="/api/medicineReport")
public class MedicineReportController {

	@Autowired(required=true)
	private MedicineReportRepo repo;
	
	@GetMapping(value="/getAllReports")
	public List<MedicineReport> getAllReports(){
		return repo.findAll();
	}
	@PostMapping("/add")
	public void saveReport(@Validated @RequestBody MedicineReport med) {
	repo.save(med);
	}
	
	@GetMapping(value="/getPatientReports/{id}")
	public Optional<MedicineReport> getPatientReports(@PathVariable Integer id) {
		 return repo.findById(id);
		 
	}
}
