package com.coronaconsultation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coronaconsultation.entities.Treatment;

public interface TreatmentRepository extends JpaRepository<Treatment, Integer>{

}
