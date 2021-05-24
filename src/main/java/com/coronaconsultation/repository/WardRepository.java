package com.coronaconsultation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coronaconsultation.entities.Ward;

public interface WardRepository extends JpaRepository<Ward, Integer> {

}
