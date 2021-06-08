package com.coronaconsultation.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.coronaconsultation.entities.PatientRequests;

public interface IPatientRequestServices {
	public boolean setNewRequest(PatientRequests patientRequests);
	public List<PatientRequests> getAllRequests();
	public PatientRequests getPatientRequestById(int id);
	public boolean RemovePatientRequestById(int id);
	
	//@Query(value="select e from PatientRequest e where empName = ?1 limit 1", nativeQuery=true)
    //public PatientRequests findByEmail(String empName);
	
	public boolean deleteAllRequests();
	//public boolean AcceptRequestById(int id);
	//public boolean AcceptRequestById(PatientRequests patientRequests, int ServiceId, String additionalServices);

}
