package com.coronaconsultation.services;

import com.coronaconsultation.entities.DoctorReport;
import com.coronaconsultation.entities.Feedback;
import com.coronaconsultation.entities.Patient;
import com.coronaconsultation.entities.PatientReport;
import com.coronaconsultation.entities.PatientRequests;
import com.coronaconsultation.entities.Services;
import com.coronaconsultation.entities.Treatment;

public interface IPatientServices {
	//public boolean AcceptPatient(PatientRequests patientRequests);
	public boolean DischargePatient(int id, String discharge);
	public boolean AddTreatment(int id, Treatment treatment);
	public boolean AddDoctorReport(int id, DoctorReport doctorReport);
	public boolean AddPatientReport(int id,PatientReport patientReport);
	//public boolean AddBills(int id);
	public boolean GiveFeedback(int id, Feedback feedback);
	public PatientReport ViewPatientReport(int id);
	public DoctorReport ViewDoctorReport(int id);
	public String ViewTreatment(int id);
	public String ViewDischargeSummary(int id);
	boolean AcceptPatient(PatientRequests patientRequests, Services services, PatientReport patientReport,
			DoctorReport doctorReport, Feedback feedback);
	

}
