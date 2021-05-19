package com.coronaconsultation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coronaconsultation.entities.DoctorReport;
import com.coronaconsultation.repository.DoctorReportRepository;
import com.coronaconsultation.repository.DoctorRepository;

@Service
public class DoctorReportImpl implements IDoctorReport {
	@Autowired
	DoctorReportRepository doctorReportRepository;

	@Override
	public boolean createDoctorReport(DoctorReport doctorReport) {
		doctorReportRepository.save(doctorReport);
		// TODO Auto-generated method stub
		return true;
	}

}
