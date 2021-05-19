package com.coronaconsultation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coronaconsultation.entities.PatientRequests;

public interface PatientRequestRepository extends JpaRepository<PatientRequests, Integer> {

}