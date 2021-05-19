package com.coronaconsultation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coronaconsultation.entities.Services;

public interface ServicesRepository extends JpaRepository<Services, Integer> {
	
}
