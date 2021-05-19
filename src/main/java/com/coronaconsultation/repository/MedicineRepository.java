package com.coronaconsultation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coronaconsultation.entities.Medicine;

public interface MedicineRepository  extends JpaRepository<Medicine, Integer>{

}
