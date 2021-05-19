package com.coronaconsultation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coronaconsultation.entities.Patient;

public interface PatientRepository  extends JpaRepository<Patient, Integer>{

}
