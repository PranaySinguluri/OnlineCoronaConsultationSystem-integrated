package com.coronaconsultation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coronaconsultation.entities.Patient;
import com.coronaconsultation.entities.PatientRequests;
import com.coronaconsultation.entities.ServiceType;
import com.coronaconsultation.entities.Services;
import com.coronaconsultation.repository.PatientRepository;
import com.coronaconsultation.repository.PatientRequestRepository;
import com.coronaconsultation.repository.ServicesRepository;
@Service
public class PatientRequestServicesImpl implements IPatientRequestServices{
	@Autowired
	PatientRequestRepository patientRequestRepository;
	@Autowired
	PatientRepository patientRepository;
	@Autowired 
	ServicesRepository servicesRepository;
	@Override
	public boolean setNewRequest(PatientRequests patientRequests) {
		// TODO Auto-generated method stub
		if(patientRequests!= null) {
			patientRequestRepository.save(patientRequests);
			
			return true;
		}
		return false;
	}

	
	@Override
	public List<PatientRequests> getAllRequests() {
		// TODO Auto-generated method stub
		return patientRequestRepository.findAll();
	}

	@Override
	public PatientRequests getPatientRequestById(int id) {
		// TODO Auto-generated method stub
		PatientRequests patientRequests= patientRequestRepository.findById(id).get();
		if(patientRequests!=null) {
			return patientRequests;
		}
		return null;
	}

	@Override
	public boolean RemovePatientRequestById(int id) {
		// TODO Auto-generated method stub
		PatientRequests patientRequests= patientRequestRepository.findById(id).get();
		if(patientRequests!=null) {
			patientRequestRepository.deleteById(id);
			return true;
		}
		
		return false;
	}

	@Override
	public boolean deleteAllRequests() {
		// TODO Auto-generated method stub
		patientRequestRepository.deleteAll();
		return false;
	}
	 
	

}
