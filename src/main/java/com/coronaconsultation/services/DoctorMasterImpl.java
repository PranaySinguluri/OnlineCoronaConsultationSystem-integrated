package com.coronaconsultation.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.coronaconsultation.entities.DischargedPatients;
import com.coronaconsultation.entities.Doctor;
import com.coronaconsultation.entities.DoctorReport;
import com.coronaconsultation.entities.Gender;
import com.coronaconsultation.entities.Patient;
import com.coronaconsultation.entities.PatientReport;
import com.coronaconsultation.entities.Treatment;
import com.coronaconsultation.repository.DischargePatientsRepository;
import com.coronaconsultation.repository.DoctorReportRepository;
import com.coronaconsultation.repository.DoctorRepository;
import com.coronaconsultation.repository.PatientRepository;

@Service
public class DoctorMasterImpl implements IDoctorMaster{
@Autowired
private DoctorRepository doctorRepository;
@Autowired
DoctorReportRepository doctorReportRepository;
@Autowired
PatientRepository patientRepository;
@Autowired
DischargePatientsRepository dischargePatientsRepository;
@Override
public boolean createDoctor(Doctor doctor) {
	// TODO Auto-generated method stub
	if(doctor!=null)
	{
		doctorRepository.save(doctor);
		return true;
	}
	return false;
}

@Override
public boolean updateDoctor(int id,Doctor doctor) {
	Doctor doc = doctorRepository.findById(id).get();

	if (doc!=null) {
		
		doctorRepository.save(doc);
		return true;
		
	}

	
	return false;
}


@Override
public boolean deleteDoctor(int id) {
	// TODO Auto-generated method stub
	Doctor doc =doctorRepository.findById(id).get();
	if(doc!=null) {
		doctorRepository.deleteById(id);;
		return true;
	}
	return false;
}

@Override
public Doctor getDoctor(int id) {
	// TODO Auto-generated method stub
	Doctor doc= doctorRepository.findById(id).get();
	if(doc!=null) {
		return doc;
	}
	return null;
}

@Override
public List<Doctor> getAllDoctors() {
	// TODO Auto-generated method stub
	   List<Doctor> doctor= doctorRepository.findAll();
	   if(doctor!=null) {
		   return doctor;
	   }
	return null;
}

@Override
public boolean updateName(int id, String name) {
	// TODO Auto-generated method stub
	Doctor doc = doctorRepository.findById(id).get();

	if (doc!=null) {
		doc.setName(name);

		doctorRepository.save(doc);
		return true;
	}
	return false;
}

@Override
public boolean updateGender(int id, Gender gender) {
	// TODO Auto-generated method stub
	Doctor doc = doctorRepository.findById(id).get();

	if (doc!=null) {
		doc.setGender(gender);

		doctorRepository.save(doc);
		return true;
	}
	
	return false;
}

@Override
public boolean updateSpecialization(int id, String specialization) {
	// TODO Auto-generated method stub
	Doctor doc = doctorRepository.findById(id).get();

	if (doc!=null) {
		doc.setSpecialization(specialization);

		doctorRepository.save(doc);
		return true;
	}
	return false;
}

@Override
public boolean updateEmail(int id, String email) {
	// TODO Auto-generated method stub
	Doctor doc = doctorRepository.findById(id).get();

	if (doc!=null) {
		doc.setEmail(email);
		doctorRepository.save(doc);
		return true;
	}
	
	
	return false;
}

@Override
public boolean updateMobile(int id, String mobile) {
	// TODO Auto-generated method stub
	Doctor doc = doctorRepository.findById(id).get();

	if (doc!=null) {
		doc.setMobile(mobile);
		
		doctorRepository.save(doc);
		return true;
	}
	
	
	return false;
}


@Override
public boolean createDoctorReport(int id,DoctorReport doctorReport) {
	// TODO Auto-generated method stub
	Patient patient = patientRepository.findById(id).get();
	if(patient!=null) {
		doctorReportRepository.save(doctorReport);
		patient.setDoctorReport(doctorReport);
		patientRepository.save(patient);
		return true;
	}
	// TODO Auto-generated method stub
	
	return false;
}


@Override
public boolean AddPatientReport(int id, PatientReport patientReport) {
	// TODO Auto-generated method stub
	Patient patient= patientRepository.findById(id).get();
	if(patient!=null) {
		patient.setPatientReport(patientReport);
		return true;
	}
	return false;
}

@Override
public boolean AddTreatment(int id,Treatment treatment) {
	// TODO Auto-generated method stub
	Patient patient= patientRepository.findById(id).get();
	if(patient!=null) {
		patient.setTreatment(treatment.getTreatement()+"\nBy "+treatment.getDoctor().getName());
		return true;
	}
	
	return false;
}

@Override
public boolean DischargePatient(int id, String dischargeSummary) {
	Patient patient= patientRepository.findById(id).get();
	DischargedPatients dischargedPatients= new DischargedPatients();
	if(patient!=null) {
		dischargedPatients.setPatient(patient);
		dischargedPatients.setDischargeSummary(dischargeSummary);
		dischargedPatients.setDoctor(patient.getDoctorReport().getDoctor());
		return true;
	}
	// TODO Auto-generated method stub
	
	return false;
}

@Override
public PatientReport ViewPatientReport(int id) {
	// TODO Auto-generated method stub
	Patient patient= patientRepository.findById(id).get();
	if(patient!=null) {
		return patient.getPatientReport();
	}
	return null;
}

@Override
public DoctorReport ViewDoctorReport(int id) {
	// TODO Auto-generated method stub
	Patient patient= patientRepository.findById(id).get();
	if(patient!=null) {
		return patient.getDoctorReport();
	}
	return null;
}

@Override

public String ViewTreatment(int id) {
	// TODO Auto-generated method stub
	Patient patient= patientRepository.findById(id).get();
	if(patient!=null) {
		return patient.getTreatment();
	}
	return null;
}

@Override
public String ViewDischargeSummary(int id) {
	// TODO Auto-generated method stub
	Patient patient= patientRepository.findById(id).get();
	if(patient!=null) {
		String summary=dischargePatientsRepository.findById(id).get().getDischargeSummary();
		String message=summary+"\nBy "+dischargePatientsRepository.findById(id).get().getDoctor().getName();
		return message;
	}
	return null;
}

}



