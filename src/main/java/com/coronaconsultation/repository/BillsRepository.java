package com.coronaconsultation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coronaconsultation.entities.Bills;

public interface BillsRepository extends JpaRepository<Bills, Integer> {

}
