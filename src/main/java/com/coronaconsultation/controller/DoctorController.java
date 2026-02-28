package com.coronaconsultation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

    @Autowired
    private DoctorMasterImpl doctorMasterImpl;

    @PostMapping(value = "/CreateDoctor")
    public ResponseEntity<String> createDoctor(@RequestBody Doctor doctor) {
        try {
            doctorMasterImpl.createDoctor(doctor);
            return new ResponseEntity<>("Doctor Created!!", HttpStatus.OK);
        } catch (DoctorNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Doctor not created", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/updateDoctor/updateAllFields/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateDoctor(@PathVariable int id, @RequestBody Doctor doctor) {
        try {
            if (doctorMasterImpl.updateDoctor(id, doctor)) {
                return new ResponseEntity<>("Doctor Updated!!", HttpStatus.OK);
            }
        } catch (DoctorNotFoundException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("No such id Exists!!", HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/updateDoctor/updateName/{id}", consumes = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> updateDoctorName(@PathVariable int id, @RequestBody String name) {
        try {
            if (doctorMasterImpl.updateName(id, name)) {
                return new ResponseEntity<>("Name Updated!!", HttpStatus.OK);
            }
        } catch (DoctorNotFoundException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("No such id Exists!!", HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/updateDoctor/updateEmail/{id}", consumes = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> updateDoctorEmail(@PathVariable int id, @RequestBody String email) {
        try {
            if (doctorMasterImpl.updateEmail(id, email)) {
                return new ResponseEntity<>("Email Updated!!", HttpStatus.OK);
            }
        } catch (DoctorNotFoundException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("No such id Exists!!", HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/updateDoctor/updateMobile/{id}", consumes = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> updateDoctorMobile(@PathVariable int id, @RequestBody String mobile) {
        try {
            if (doctorMasterImpl.updateMobile(id, mobile)) {
                return new ResponseEntity<>("Mobile Updated!!", HttpStatus.OK);
            }
        } catch (DoctorNotFoundException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("No such id Exists!!", HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/updateDoctor/updateGender/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateDoctorGender(@PathVariable int id, @RequestBody Gender gender) {
        try {
            if (doctorMasterImpl.updateGender(id, gender)) {
                return new ResponseEntity<>("Gender Updated!!", HttpStatus.OK);
            }
        } catch (DoctorNotFoundException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("No such id Exists!!", HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/updateDoctor/updateSpecialization/{id}", consumes = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> updateDoctorSpecialization(@PathVariable int id, @RequestBody String specialization) {
        try {
            if (doctorMasterImpl.updateSpecialization(id, specialization)) {
                return new ResponseEntity<>("Specialization Updated!!", HttpStatus.OK);
            }
        } catch (DoctorNotFoundException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("No such id Exists!!", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable int id) {
        try {
            if (doctorMasterImpl.deleteDoctor(id)) {
                return new ResponseEntity<>("Doctor deleted !!", HttpStatus.OK);
            }
        } catch (DoctorNotFoundException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("No such id Exists!!", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctor(@PathVariable int id) {
        try {
            Doctor doc = doctorMasterImpl.getDoctor(id);
            if (doc != null) return new ResponseEntity<>(doc, HttpStatus.OK);
        } catch (DoctorNotFoundException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/allDoctors")
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        try {
            List<Doctor> doc = doctorMasterImpl.getAllDoctors();
            if (doc != null) return new ResponseEntity<>(doc, HttpStatus.OK);
        } catch (DoctorNotFoundException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/ViewTreatment/{id}")
    public ResponseEntity<List<Treatment>> viewTreatment(@PathVariable int id) {
        List<Treatment> treatment = doctorMasterImpl.ViewTreatment(id);
        if (treatment != null) return new ResponseEntity<>(treatment, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/DoctorReport/{id}")
    public ResponseEntity<?> viewDoctorReport(@PathVariable int id) {
        try {
            DoctorReport doctorReport = doctorMasterImpl.ViewDoctorReport(id);
            if (doctorReport != null) return new ResponseEntity<>(doctorReport, HttpStatus.OK);
        } catch (PatientNotFoundException e) {
            ErrorDetails errorDetails = new ErrorDetails();
            errorDetails.setErrorMessage(e.getMessage());
            return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/PatientReport/{id}")
    public ResponseEntity<PatientReport> viewPatientReport(@PathVariable int id) {
        PatientReport patientReport = doctorMasterImpl.ViewPatientReport(id);
        if (patientReport != null) return new ResponseEntity<>(patientReport, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/AddTreatment/Patient/{id}/Doctor/{docId}/treatment/{treatId}", consumes = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> addTreatment(
            @PathVariable int id,
            @PathVariable int docId,
            @PathVariable int treatId,
            @RequestBody String newTreatment) {

        Patient patient = doctorMasterImpl.ViewPatient(id);
        Doctor doctor = doctorMasterImpl.getDoctor(docId);

        if (patient == null) return new ResponseEntity<>("No such patient exists!!", HttpStatus.NOT_FOUND);
        if (doctor == null)  return new ResponseEntity<>("No such Doctor exists!!", HttpStatus.NOT_FOUND);

        doctorMasterImpl.AddTreatment(treatId, patient, doctor, newTreatment);
        return new ResponseEntity<>("Treatment Submitted!!", HttpStatus.CREATED);
    }

    @GetMapping("/ViewPatient/{patientId}")
    public ResponseEntity<Patient> viewPatient(@PathVariable int patientId) {
        Patient patient = doctorMasterImpl.ViewPatient(patientId);
        if (patient != null) return new ResponseEntity<>(patient, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}