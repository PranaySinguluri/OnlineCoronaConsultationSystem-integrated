package com.coronaconsultation.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coronaconsultation.entities.Medicine;
import com.coronaconsultation.entities.MedicineReport;
import com.coronaconsultation.exception.MedicineIdNotFoundException;
import com.coronaconsultation.exception.MedicineReportIdNotFoundException;
import com.coronaconsultation.repository.MedicineReportRepo;
@Service
public class MedicineReportServiceImpl implements IMedicineReport {
	@Autowired
	private MedicineReportRepo repo;
	
	@Override
	public List<MedicineReport> getAllReports() {
		
		return repo.findAll();
	}

	@Override
	public Optional<MedicineReport> getPatientReports(int id) throws MedicineReportIdNotFoundException {
		 try {
	    	   return repo.findById(id);
	       }
	       catch (Exception e) {
	    	   throw new  MedicineReportIdNotFoundException(id);
	       }
	}

	@Override
	public MedicineReport saveReport(MedicineReport med) {
		
		return repo.save(med);
	
	}

}
