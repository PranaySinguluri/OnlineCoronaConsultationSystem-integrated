package com.coronaconsultation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coronaconsultation.entities.DischargedPatients;

public interface DischargePatientsRepository extends JpaRepository<DischargedPatients, Integer>{

}
