package com.coronaconsultation.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.coronaconsultation.entities.Medicine;
import com.coronaconsultation.entities.MedicineReport;
@Service
public interface IMedicineReport {
	public List<MedicineReport> getAllReports();
	public MedicineReport saveReport(MedicineReport med);
	public Optional<MedicineReport> getPatientReports(int id);
}
