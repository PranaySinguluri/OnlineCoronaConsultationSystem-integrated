package com.coronaconsultation.services;

import java.util.List;

import com.coronaconsultation.entities.Doctor;
import com.coronaconsultation.entities.DoctorReport;
import com.coronaconsultation.entities.Gender;
import com.coronaconsultation.entities.PatientReport;
import com.coronaconsultation.entities.Treatment;
import com.coronaconsultation.exception.DoctorNotFoundException;
import com.coronaconsultation.exception.EmployeeNotFoundException;

public interface IDoctorMaster {
	public boolean createDoctor(Doctor doctor) throws DoctorNotFoundException;
	public boolean updateDoctor(int id,Doctor doctor) throws DoctorNotFoundException;
	public boolean deleteDoctor(int id) throws DoctorNotFoundException;
	public Doctor getDoctor(int id) throws DoctorNotFoundException;
	public List<Doctor> getAllDoctors() throws DoctorNotFoundException;
	public boolean updateName(int id,String name) throws DoctorNotFoundException;
	public boolean updateGender(int id,Gender gender) throws DoctorNotFoundException;
	public boolean updateSpecialization(int id,String specialization) throws DoctorNotFoundException;
	public boolean updateEmail(int id,String email) throws DoctorNotFoundException;
	public boolean updateMobile(int id,String mobile) throws DoctorNotFoundException;
	public boolean createDoctorReport(int id,DoctorReport doctorReport);
	public boolean AddPatientReport(int id, PatientReport patientReport);
	public boolean AddTreatment(int id, Treatment treatment);
	public boolean DischargePatient(int id, String dischargeSummary);
	public String ViewDischargeSummary(int id);
	public String ViewTreatment(int id);
	public DoctorReport ViewDoctorReport(int id);
	public PatientReport ViewPatientReport(int id);

}
