package com.coronaconsultation.services;

import java.util.List;
import java.util.Optional;

import com.coronaconsultation.entities.Doctor;
import com.coronaconsultation.entities.DoctorReport;
import com.coronaconsultation.entities.Gender;
import com.coronaconsultation.entities.Patient;
import com.coronaconsultation.entities.PatientReport;
import com.coronaconsultation.entities.Treatment;
import com.coronaconsultation.exception.DoctorNotFoundException;
import com.coronaconsultation.exception.PatientNotFoundException;

public interface IDoctorMaster {
	public boolean createDoctor(Doctor doctor) throws DoctorNotFoundException;

	public boolean updateDoctor(int id, Doctor doctor) throws DoctorNotFoundException;

	public boolean deleteDoctor(int id) throws DoctorNotFoundException;

	public Doctor getDoctor(int id) throws DoctorNotFoundException;

	public List<Doctor> getAllDoctors() throws DoctorNotFoundException;

	public boolean updateName(int id, String name) throws DoctorNotFoundException;

	public boolean updateGender(int id, Gender gender) throws DoctorNotFoundException;

	public boolean updateSpecialization(int id, String specialization) throws DoctorNotFoundException;

	public boolean updateEmail(int id, String email) throws DoctorNotFoundException;

	public boolean updateMobile(int id, String mobile) throws DoctorNotFoundException;

	public boolean createDoctorReport(int id, DoctorReport doctorReport) throws PatientNotFoundException;

	//public boolean AddPatientReport(int id, PatientReport patientReport) throws PatientNotFoundException;

	//public boolean AddTreatment(int id, Treatment treatment) throws PatientNotFoundException;

	public boolean DischargePatient(int id, String dischargeSummary) throws PatientNotFoundException;

	public String ViewDischargeSummary(int id) throws PatientNotFoundException;

	public List<Treatment> ViewTreatment(int id) throws PatientNotFoundException;

	public DoctorReport ViewDoctorReport(int id) throws PatientNotFoundException;

	public PatientReport ViewPatientReport(int id) throws PatientNotFoundException;
	public Patient ViewPatient(int id) throws PatientNotFoundException;

	public boolean AddTreatment(int id, Patient patient, Doctor doctor, String NewTreatment) throws PatientNotFoundException;

	public boolean AddPatientReport(int id, PatientReport patientReport) throws PatientNotFoundException;

}
