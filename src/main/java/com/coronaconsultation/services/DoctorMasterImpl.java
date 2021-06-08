package com.coronaconsultation.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.coronaconsultation.entities.DischargedPatients;
import com.coronaconsultation.entities.Doctor;
import com.coronaconsultation.entities.DoctorReport;
import com.coronaconsultation.entities.Gender;
import com.coronaconsultation.entities.Patient;
import com.coronaconsultation.entities.PatientReport;
import com.coronaconsultation.entities.Treatment;
import com.coronaconsultation.exception.DoctorNotFoundException;
import com.coronaconsultation.exception.PatientNotFoundException;
import com.coronaconsultation.repository.DischargePatientsRepository;
import com.coronaconsultation.repository.DoctorReportRepository;
import com.coronaconsultation.repository.DoctorRepository;
import com.coronaconsultation.repository.PatientRepository;
import com.coronaconsultation.repository.TreatmentRepository;

@Service
public class DoctorMasterImpl implements IDoctorMaster {
	@Autowired
	private DoctorRepository doctorRepository;
	@Autowired
	private DoctorReportRepository doctorReportRepository;
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private DischargePatientsRepository dischargePatientsRepository;

	@Override
	public boolean createDoctor(Doctor doctor) throws DoctorNotFoundException {
		// TODO Auto-generated method stub
		if (doctor != null) {
			doctorRepository.save(doctor);
			return true;
		} else {
			throw new DoctorNotFoundException("Doctor Exists already!!");
		}
	}

	@Override
	public boolean updateDoctor(int id, Doctor doctor) throws DoctorNotFoundException {
		Doctor doc = doctorRepository.findById(id).get();

		if (doc != null) {

			doctorRepository.save(doc);
			return true;

		}

		else {
			throw new DoctorNotFoundException("Doctor Not Found!!");
		}
	}

	@Override
	public boolean deleteDoctor(int id) throws DoctorNotFoundException {
		// TODO Auto-generated method stub
		Doctor doc = doctorRepository.findById(id).get();
		if (doc != null) {
			doctorRepository.deleteById(id);
			;
			return true;
		} else {
			throw new DoctorNotFoundException("Doctor Not Found!!");
		}
	}

	@Override
	public Doctor getDoctor(int id) throws DoctorNotFoundException {
		// TODO Auto-generated method stub
		Doctor doc = doctorRepository.findById(id).get();
		if (doc != null) {
			return doc;
		} else {
			throw new DoctorNotFoundException("Doctor Not Found!!");
		}
	}

	@Override
	public List<Doctor> getAllDoctors() throws DoctorNotFoundException {
		// TODO Auto-generated method stub
		List<Doctor> doctor = doctorRepository.findAll();
		if (doctor != null) {
			return doctor;
		} else {
			throw new DoctorNotFoundException("Doctor Not Found!!");
		}
	}

	@Override
	public boolean updateName(int id, String name) throws DoctorNotFoundException {
		// TODO Auto-generated method stub
		Doctor doc = doctorRepository.findById(id).get();

		if (doc != null) {
			doc.setName(name);

			doctorRepository.save(doc);
			return true;
		} else {
			throw new DoctorNotFoundException("Doctor Not Found!!");
		}
	}

	@Override
	public boolean updateGender(int id, Gender gender) throws DoctorNotFoundException {
		// TODO Auto-generated method stub
		Doctor doc = doctorRepository.findById(id).get();

		if (doc != null) {
			doc.setGender(gender);

			doctorRepository.save(doc);
			return true;
		}

		else {
			throw new DoctorNotFoundException("Doctor Not Found!!");
		}
	}

	@Override
	public boolean updateSpecialization(int id, String specialization) throws DoctorNotFoundException {
		// TODO Auto-generated method stub
		Doctor doc = doctorRepository.findById(id).get();

		if (doc != null) {
			doc.setSpecialization(specialization);

			doctorRepository.save(doc);
			return true;
		} else {
			throw new DoctorNotFoundException("Doctor Not Found!!");
		}
	}

	@Override
	public boolean updateEmail(int id, String email) throws DoctorNotFoundException {
		// TODO Auto-generated method stub
		Doctor doc = doctorRepository.findById(id).get();

		if (doc != null) {
			doc.setEmail(email);
			doctorRepository.save(doc);
			return true;
		}

		else {
			throw new DoctorNotFoundException("Doctor Not Found!!");
		}
	}

	@Override
	public boolean updateMobile(int id, String mobile) throws DoctorNotFoundException {
		// TODO Auto-generated method stub
		Doctor doc = doctorRepository.findById(id).get();

		if (doc != null) {
			doc.setMobile(mobile);

			doctorRepository.save(doc);
			return true;
		}

		else {
			throw new DoctorNotFoundException("Doctor Not Found!!");
		}
	}

	@Override
	public boolean createDoctorReport(int id, DoctorReport doctorReport) throws PatientNotFoundException{
		// TODO Auto-generated method stub
		Patient patient = patientRepository.findById(id).get();
		if (patient != null) {
			doctorReportRepository.save(doctorReport);
			patient.setDoctorReport(doctorReport);
			patientRepository.save(patient);
			return true;
		} else {
			throw new PatientNotFoundException("patient not found!!");
		}
		// TODO Auto-generated method stub

	}

	@Override
	public boolean AddPatientReport(int id, PatientReport patientReport) throws PatientNotFoundException {
		// TODO Auto-generated method stub
		Patient patient = patientRepository.findById(id).get();
		if (patient != null) {
			patient.setPatientReport(patientReport);
			return true;
		} else {
			throw new PatientNotFoundException("patient not found!!");
		}
	}
	
	@Autowired
	private TreatmentRepository treatmentRepository;
	@Override
	public boolean AddTreatment(int id, Patient patient, Doctor doctor, String NewTreatment) throws PatientNotFoundException{
		// TODO Auto-generated method stub
		//treatmentRepository.save(treatment);
		//Patient patient = patientRepository.findById(id).get();
		Treatment treatment= new Treatment();
		if (patient != null) {
			treatment.setDoctor(doctor);
			treatment.setPatient(patient);
			treatment.setId(id);
			treatment.setTreatement(NewTreatment);
			treatmentRepository.save(treatment);
			return true;
		} else {
			throw new PatientNotFoundException("patient not found!!");
		}

	}

	@Override
	public boolean DischargePatient(int id, String dischargeSummary) throws PatientNotFoundException {
		Patient patient = patientRepository.findById(id).get();
		DischargedPatients dischargedPatients = new DischargedPatients();
		if (patient != null) {
			dischargedPatients.setPatient(patient);
			dischargedPatients.setDischargeSummary(dischargeSummary);
			dischargedPatients.setDoctor(patient.getDoctorReport().getDoctor());
			return true;
		} else {
			throw new PatientNotFoundException("patient not found!!");
		}
		// TODO Auto-generated method stub

	}

	@Override
	public PatientReport ViewPatientReport(int id) throws PatientNotFoundException {
		// TODO Auto-generated method stub
		Patient patient = patientRepository.findById(id).get();
		if (patient != null) {
			return patient.getPatientReport();
		} else {
			throw new PatientNotFoundException("patient not found!!");
		}
	}

	@Override
	public DoctorReport ViewDoctorReport(int id) throws PatientNotFoundException {
		// TODO Auto-generated method stub
		Patient patient = patientRepository.findById(id).get();
		if (patient != null) {
			return patient.getDoctorReport();
		} else {
			throw new PatientNotFoundException("patient not found!!");
		}
	}

	@Override

	public List<Treatment> ViewTreatment(int id) throws PatientNotFoundException {
		// TODO Auto-generated method stub
		Patient patient= patientRepository.findById(id).get();
		List<Treatment> treatment = patient.getTreatement();
		System.out.println("\n\n\n\n-->"+treatment+"-->\n\n\n\n");
		if (treatment != null) {
			//int treatId=patient.getTreatement().getId();
			//Treatment treatment= treatmentRepository.findById(treatId).get();
			//System.out.println(treatment);
			return treatment;
		}
		throw new PatientNotFoundException("patient not found!!");
	}

	@Override
	public String ViewDischargeSummary(int id) throws PatientNotFoundException{
		// TODO Auto-generated method stub
		Patient patient = patientRepository.findById(id).get();
		if (patient != null) {
			String summary = dischargePatientsRepository.findById(id).get().getDischargeSummary();
			String message = summary + "\nBy " + dischargePatientsRepository.findById(id).get().getDoctor().getName();
			return message;
		} else {
			throw new PatientNotFoundException("patient not found!!");
		}
	}

	@Override
	public Patient ViewPatient(int patientId) throws PatientNotFoundException{
		// TODO Auto-generated method stub
		Patient patient= patientRepository.findById(patientId).get();
		if(patient!=null) {
			return patient;
		}
		else
		{
			throw new PatientNotFoundException("patient not found!!");
		}
	}


}
