package com.coronaconsultation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coronaconsultation.entities.Doctor;
import com.coronaconsultation.entities.DoctorReport;
import com.coronaconsultation.entities.Gender;
import com.coronaconsultation.entities.Patient;
import com.coronaconsultation.entities.PatientReport;
import com.coronaconsultation.entities.Treatment;
import com.coronaconsultation.exception.DoctorNotFoundException;
import com.coronaconsultation.exception.ErrorDetails;
import com.coronaconsultation.exception.PatientNotFoundException;
import com.coronaconsultation.services.DoctorMasterImpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("api/doctor/")
public class DoctorController {
	@Autowired
	private DoctorMasterImpl doctorMasterImpl;

	@PostMapping("/")
	public ResponseEntity<String> createDoctor(@RequestBody int id, @RequestBody String name, @RequestBody String email, @RequestBody String mobile, @RequestBody String specialization, @RequestBody Gender gender) {
		Doctor doctor= new Doctor();
		doctor.setName(name);
		doctor.setEmail(email);
		doctor.setGender(gender);
		doctor.setId(id);
		doctor.setMobile(mobile);
		doctor.setSpecialization(specialization);
		try {
			doctorMasterImpl.createDoctor(doctor);
		} catch (DoctorNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>("Doctor Created!!", HttpStatus.OK);

	}

	@PutMapping("/updateDoctor/updateAllFields/{id}/")
	public ResponseEntity<String> updateDoctor(@PathVariable int id, @RequestBody Doctor doctor) {
		try {
			if (doctorMasterImpl.updateDoctor(id, doctor)) {
				return new ResponseEntity<>("Doctor Updated!!", HttpStatus.OK);
			}
		} catch (DoctorNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>("No such id Exists!!", HttpStatus.NOT_FOUND);
	}

	@PutMapping("/updateDoctor/updateName/")
	public ResponseEntity<String> updateDoctorName(@RequestBody int id, @RequestBody
			String name) {

		System.out.println("Name Was:: " + name);
		try {
			if (doctorMasterImpl.updateName(id, name)) {
				return new ResponseEntity<>("Name Updated!!", HttpStatus.OK);
			}
		} catch (DoctorNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>("No such id Exists!!", HttpStatus.NOT_FOUND);
	}

	@PutMapping("/updateDoctor/updateEmail/{id}/")
	public ResponseEntity<String> updateDoctorEmail(@PathVariable int id, @RequestBody String email) {
		try {
			if (doctorMasterImpl.updateEmail(id, email)) {
				return new ResponseEntity<>("Email Updated!!", HttpStatus.OK);
			}
		} catch (DoctorNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>("No such id Exists!!", HttpStatus.NOT_FOUND);
	}

	@PutMapping("/updateDoctor/updateMobile/{id}/")
	public ResponseEntity<String> updateDoctorMobile(@PathVariable int id, @RequestBody String mobile) {
		try {
			if (doctorMasterImpl.updateMobile(id, mobile)) {
				return new ResponseEntity<>("Mobile Updated!!", HttpStatus.OK);
			}
		} catch (DoctorNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>("No such id Exists!!", HttpStatus.NOT_FOUND);
	}

	@PutMapping("/updateDoctor/updateGender/{id}/")
	public ResponseEntity<String> updateDoctorGender(@PathVariable int id, @RequestBody Gender gender) {
		try {
			if (doctorMasterImpl.updateGender(id, gender)) {
				return new ResponseEntity<>("Gender Updated!!", HttpStatus.OK);
			}
		} catch (DoctorNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>("No such id Exists!!", HttpStatus.NOT_FOUND);
	}

	@PutMapping("/updateDoctor/updateSpecialization/{id}/")
	public ResponseEntity<String> updateDoctorSpecialization(@PathVariable int id, @RequestBody String specialization) {
		try {
			if (doctorMasterImpl.updateSpecialization(id, specialization)) {
				return new ResponseEntity<>("Specialization Updated!!", HttpStatus.OK);
			}
		} catch (DoctorNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>("No such id Exists!!", HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}/")
	public ResponseEntity<String> deleteDoctor(@PathVariable int id) {
		try {
			if (doctorMasterImpl.deleteDoctor(id)) {
				return new ResponseEntity<String>("Doctor deleted !!", HttpStatus.OK);
			}
		} catch (DoctorNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>("No such id Exists!!", HttpStatus.NOT_FOUND);
	}

	@GetMapping("/{id}/")
	public ResponseEntity<Doctor> getDoctor(@PathVariable int id) {
		Doctor doc;
		try {
			doc = doctorMasterImpl.getDoctor(id);
			if (doc != null) {
				return new ResponseEntity<>(doc, HttpStatus.OK);
			}
		} catch (DoctorNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@GetMapping("/allDoctors")
	public ResponseEntity<List<Doctor>> getAllDoctors() {
		List<Doctor> doc;
		try {
			doc = doctorMasterImpl.getAllDoctors();
			if (doc != null) {
				return new ResponseEntity<>(doc, HttpStatus.OK);
			}
		} catch (DoctorNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@GetMapping("/ViewTreatment/{id}/")
	public ResponseEntity<List<Treatment>> ViewTreatment(@PathVariable int id) {
		List<Treatment> treatment = doctorMasterImpl.ViewTreatment(id);
		System.out.println(treatment);
		if (treatment != null) {
			return new ResponseEntity<>(treatment, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

	}

	@GetMapping("/DoctorReport/{id}/")
	public ResponseEntity<DoctorReport> ViewDoctorReport(@PathVariable int id) {
		DoctorReport doctorReport;
		try {
			doctorReport = doctorMasterImpl.ViewDoctorReport(id);
			if (doctorReport != null) {
				return new ResponseEntity<>(doctorReport, HttpStatus.OK);
			}
		} catch (PatientNotFoundException e) {
			// TODO: handle exception
			ErrorDetails errorDetails = new ErrorDetails();
			errorDetails.setErrorMessage(e.getMessage());

		}

		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@GetMapping("/PatientReport/{id}/")
	public ResponseEntity<PatientReport> ViewPatientReport(@PathVariable int id) {
		PatientReport patientReport = doctorMasterImpl.ViewPatientReport(id);

		if (patientReport != null) {
			return new ResponseEntity<>(patientReport, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@PutMapping("/AddTreatment/Patient/{id}/Doctor/{docId}/treatment/{treatId}/")
	public ResponseEntity<String> AddTreatment(@PathVariable int id, @PathVariable int docId, @PathVariable int treatId,
			@RequestBody String NewTreatment) {
		Patient patient = doctorMasterImpl.ViewPatient(id);
		Doctor doctor = doctorMasterImpl.getDoctor(docId);
		System.out.println(doctor);

		if (patient != null) {
			if (doctor != null) {
				doctorMasterImpl.AddTreatment(treatId, patient, doctor, NewTreatment);

				return new ResponseEntity<>("Treatment Submitted!!", HttpStatus.CREATED);
			}
			return new ResponseEntity<>("No such Doctor exists!!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>("No such patient exists!!", HttpStatus.NOT_FOUND);
	}

	@GetMapping("/ViewPatient/{patientId}/")
	public ResponseEntity<Patient> ViewPatient(@PathVariable int patientId) {
		Patient patient = doctorMasterImpl.ViewPatient(patientId);
		if (patient != null) {
			return new ResponseEntity<>(patient, HttpStatus.OK);
		}

		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
}
