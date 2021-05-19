package com.coronaconsultation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.coronaconsultation.entities.Employee;
import com.coronaconsultation.entities.Feedback;
import com.coronaconsultation.entities.Gender;
import com.coronaconsultation.entities.PatientReport;
import com.coronaconsultation.entities.PatientRequests;
import com.coronaconsultation.entities.ServiceType;
import com.coronaconsultation.entities.Services;
import com.coronaconsultation.repository.DoctorReportRepository;
import com.coronaconsultation.repository.FeedbackRepository;
import com.coronaconsultation.repository.ServicesRepository;
import com.coronaconsultation.services.DoctorMasterImpl;
import com.coronaconsultation.services.EmployeeMasterImpl;
import com.coronaconsultation.services.PatientReportRepository;
import com.coronaconsultation.services.PatientRequestServicesImpl;
import com.coronaconsultation.services.PatientServicesImpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/adminController/")
public class AdminController {

	@Autowired
	private DoctorMasterImpl doctorMasterImpl;

	@PostMapping("/CreateDoctor/")
	public ResponseEntity<String> createDoctor(@RequestBody Doctor doctor) {
		doctorMasterImpl.createDoctor(doctor);
		return new ResponseEntity<>("Doctor Created!!", HttpStatus.OK);

	}

	@PutMapping("/updateDoctor/updateAllFields/{id}/")
	public ResponseEntity<String> updateDoctor(@PathVariable int id, @RequestBody Doctor doctor) {
		if (doctorMasterImpl.updateDoctor(id, doctor)) {
			return new ResponseEntity<>("Doctor Updated!!", HttpStatus.OK);
		}
		return new ResponseEntity<>("No such id Exists!!", HttpStatus.NOT_FOUND);
	}

	@PutMapping("/updateDoctor/updateName/{id}/")
	public ResponseEntity<String> updateDoctorName(@PathVariable int id, @RequestBody String name) {

		System.out.println("Name Was:: " + name);
		if (doctorMasterImpl.updateName(id, name)) {
			return new ResponseEntity<>("Name Updated!!", HttpStatus.OK);
		}
		return new ResponseEntity<>("No such id Exists!!", HttpStatus.NOT_FOUND);
	}

	@PutMapping("/updateDoctor/updateEmail/{id}/")
	public ResponseEntity<String> updateDoctorEmail(@PathVariable int id, @RequestBody String email) {
		if (doctorMasterImpl.updateEmail(id, email)) {
			return new ResponseEntity<>("Email Updated!!", HttpStatus.OK);
		}
		return new ResponseEntity<>("No such id Exists!!", HttpStatus.NOT_FOUND);
	}

	@PutMapping("/updateDoctor/updateMobile/{id}/")
	public ResponseEntity<String> updateDoctorMobile(@PathVariable int id, @RequestBody String mobile) {
		if (doctorMasterImpl.updateMobile(id, mobile)) {
			return new ResponseEntity<>("Mobile Updated!!", HttpStatus.OK);
		}
		return new ResponseEntity<>("No such id Exists!!", HttpStatus.NOT_FOUND);
	}

	@PutMapping("/updateDoctor/updateGender/{id}/")
	public ResponseEntity<String> updateDoctorGender(@PathVariable int id, @RequestBody Gender gender) {
		if (doctorMasterImpl.updateGender(id, gender)) {
			return new ResponseEntity<>("Gender Updated!!", HttpStatus.OK);
		}
		return new ResponseEntity<>("No such id Exists!!", HttpStatus.NOT_FOUND);
	}

	@PutMapping("/updateDoctor/updateSpecialization/{id}/")
	public ResponseEntity<String> updateDoctorSpecialization(@PathVariable int id, @RequestBody String specialization) {
		if (doctorMasterImpl.updateSpecialization(id, specialization)) {
			return new ResponseEntity<>("Specialization Updated!!", HttpStatus.OK);
		}
		return new ResponseEntity<>("No such id Exists!!", HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/deleteDoctor/{id}/")
	public ResponseEntity<String> deleteDoctor(@PathVariable int id) {
		if (doctorMasterImpl.deleteDoctor(id)) {
			return new ResponseEntity<String>("Doctor deleted !!", HttpStatus.OK);
		}
		return new ResponseEntity<>("No such id Exists!!", HttpStatus.NOT_FOUND);
	}

	@GetMapping("/getDoctorById/{id}/")
	public ResponseEntity<Doctor> getDoctor(@PathVariable int id) {
		Doctor doc = doctorMasterImpl.getDoctor(id);
		if (doc != null) {
			return new ResponseEntity<>(doc, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@GetMapping("/allDoctors/")
	public ResponseEntity<List<Doctor>> getAllDoctors() {
		List<Doctor> doc = doctorMasterImpl.getAllDoctors();
		if (doc != null) {
			return new ResponseEntity<>(doc, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@Autowired
	private EmployeeMasterImpl employeeMasterImpl;

	@PostMapping("/CreateEmployee/")
	public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {

		employeeMasterImpl.createEmployee(employee);
		return new ResponseEntity<>("Employee Created", HttpStatus.OK);
	}

	@PutMapping("/updateEmployee/updateAllFields/{id}/")
	public ResponseEntity<String> updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
		if (employeeMasterImpl.updateEmployee(id, employee)) {
			return new ResponseEntity<>("Employee Updated!!", HttpStatus.OK);
		}
		return new ResponseEntity<>("No such id Exists!!", HttpStatus.NOT_FOUND);
	}

	@PutMapping("/updateEmployee/updateName/{id}/")
	public ResponseEntity<String> updateEmployeeName(@PathVariable int id, @RequestBody String name) {

		System.out.println("Name Was:: " + name);
		if (employeeMasterImpl.updateName(id, name)) {
			return new ResponseEntity<>("Name Updated!!", HttpStatus.OK);
		}
		return new ResponseEntity<>("No such id Exists!!", HttpStatus.NOT_FOUND);
	}

	@PutMapping("/updateEmployee/updateEmail/{id}/")
	public ResponseEntity<String> updateEmployeeEmail(@PathVariable int id, @RequestBody String email) {
		if (employeeMasterImpl.updateEmail(id, email)) {
			return new ResponseEntity<>("Email Updated!!", HttpStatus.OK);
		}
		return new ResponseEntity<>("No such id Exists!!", HttpStatus.NOT_FOUND);
	}

	@PutMapping("/updateEmployee/updateMobile/{id}/")
	public ResponseEntity<String> updateEmployeeMobile(@PathVariable int id, @RequestBody String mobile) {
		if (employeeMasterImpl.updateMobile(id, mobile)) {
			return new ResponseEntity<>("Mobile Updated!!", HttpStatus.OK);
		}
		return new ResponseEntity<>("No such id Exists!!", HttpStatus.NOT_FOUND);
	}

	@PutMapping("/updateEmployee/updateGender/{id}/")
	public ResponseEntity<String> updateEmployeeGender(@PathVariable int id, @RequestBody Gender gender) {
		if (employeeMasterImpl.updateGender(id, gender)) {
			return new ResponseEntity<>("Gender Updated!!", HttpStatus.OK);
		}
		return new ResponseEntity<>("No such id Exists!!", HttpStatus.NOT_FOUND);
	}

	@PutMapping("/updateEmployee/updateDesignation/{id}/")
	public ResponseEntity<String> updateEmployeeDesignation(@PathVariable int id, @RequestBody String designation) {
		if (employeeMasterImpl.updateDesignation(id, designation)) {
			return new ResponseEntity<>("Designation Updated!!", HttpStatus.OK);
		}
		return new ResponseEntity<>("No such id Exists!!", HttpStatus.NOT_FOUND);
	}

	@PutMapping("/updateAddress/updateAddress/{id}/")
	public ResponseEntity<String> updateEmployeeAddress(@PathVariable int id, @RequestBody String address) {
		if (employeeMasterImpl.updateAddress(id, address)) {
			return new ResponseEntity<>("Email Updated!!", HttpStatus.OK);
		}
		return new ResponseEntity<>("No such id Exists!!", HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/deleteEmployee/{id}/")
	public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
		if (employeeMasterImpl.deleteEmployee(id)) {
			return new ResponseEntity<String>("Employee deleted !!", HttpStatus.OK);
		}
		return new ResponseEntity<>("No such id Exists!!", HttpStatus.NOT_FOUND);
	}

	@GetMapping("/getEmployeeById/{id}/")
	public ResponseEntity<Employee> getEmployee(@PathVariable int id) {
		Employee employee = employeeMasterImpl.getEmployee(id);
		if (employee != null) {
			return new ResponseEntity<>(employee, HttpStatus.OK);
		}

		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@GetMapping("/allEmployees/")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employees = employeeMasterImpl.getAllEmployees();
		if (employees != null) {
			return new ResponseEntity<>(employees, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@Autowired
	PatientRequestServicesImpl patientRequestServicesImpl;
	@Autowired
	PatientServicesImpl patientServicesImpl;

	@PostMapping("/patientRegistration/")
	public ResponseEntity<String> createRequest(@RequestBody PatientRequests patientRequests) {
		if (patientRequestServicesImpl.setNewRequest(patientRequests)) {
			return new ResponseEntity<>("Request Submitted!!", HttpStatus.CREATED);
		}
		return new ResponseEntity<>("Not Submitted!!", HttpStatus.BAD_REQUEST);

	}

	@GetMapping("/getPatientById/{id}")
	public ResponseEntity<PatientRequests> getPatientRequest(@PathVariable int id) {
		PatientRequests patientRequests = patientRequestServicesImpl.getPatientRequestById(id);
		if (patientRequests != null) {
			return new ResponseEntity<>(patientRequests, HttpStatus.FOUND);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@GetMapping("/getAllPatientsRequests/")

	public ResponseEntity<List<PatientRequests>> getAllRequest() {
		List<PatientRequests> patientRequests = patientRequestServicesImpl.getAllRequests();
		if (patientRequests != null) {
			return new ResponseEntity<>(patientRequests, HttpStatus.FOUND);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@Autowired
	PatientReportRepository patientReportRepository;

	@Autowired
	DoctorReportRepository doctorReportRepository;
	@Autowired 
	ServicesRepository servicesRepository;
	@Autowired 
	FeedbackRepository feedbackRepository;

	@GetMapping("/Accept Patient/{id}/")

	public ResponseEntity<String> AcceptRequest(@PathVariable int id, @RequestBody ServiceType servicesType, @RequestBody String additionalServices,
			@RequestBody int patientReportId, @RequestBody int doctorReportId, @RequestBody int feedId) {
		PatientRequests patientRequests =patientRequestServicesImpl.getPatientRequestById(id);
		PatientReport patientReport=patientReportRepository.findById(patientReportId).get();
		DoctorReport doctorReport =doctorReportRepository.findById(doctorReportId).get();
		Feedback feedback= feedbackRepository.findById(feedId).get();
		Services services=new Services();
		services.setAdditionalServices(additionalServices);
		if(servicesType==ServiceType.IPD) {
			services.setIPD(true);
			services.setOPD(false);
		}
		services.setIPD(false);
		services.setOPD(true);
		
		
		if(patientReport==null) {
			patientReport=new PatientReport();
			patientReport.setPatientReportId(patientReportId);
		}
		
		if(doctorReport==null) {
			doctorReport=new DoctorReport();
			doctorReport.setDocReportId(doctorReportId);
		}
		if(feedback==null) {
			feedback= new Feedback();
			feedback.setId(feedId);
		}
		
		if((patientReport!=null)&&(doctorReport !=null)&&(feedback!=null)) {
			if (patientServicesImpl.AcceptPatient(patientRequests, services, patientReport, doctorReport, feedback)) {
				return new ResponseEntity<>("Request Accepted!!", HttpStatus.OK);
				
			}
		}
		
		//PatientReport patientReport=patientReportRepository.findById(patientReportId).get();
		//DoctorReport doctorReport =doctorReportRepository.findById(doctorReportId).get();
		//Feedback feedback= feedbackRepository.findById(feedId).get();
		//PatientRequests patientRequests = patientRequestServicesImpl.getPatientRequestById(id);
		
		//if (patientServicesImpl.AcceptPatient(patientRequests, services, patientReport, doctorReport, feedback)) {
			//return new ResponseEntity<>("Request Accepted!!", HttpStatus.OK);
		///}
		return new ResponseEntity<>("No such Request!!", HttpStatus.NOT_FOUND);

	}

}
