package com.coronaconsultation.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coronaconsultation.entities.PatientReport;

public interface PatientReportRepository extends JpaRepository<PatientReport, Integer> {

}
