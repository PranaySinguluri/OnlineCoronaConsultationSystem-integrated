package com.coronaconsultation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coronaconsultation.entities.DoctorReport;

public interface DoctorReportRepository extends JpaRepository<DoctorReport, Integer>{

}
