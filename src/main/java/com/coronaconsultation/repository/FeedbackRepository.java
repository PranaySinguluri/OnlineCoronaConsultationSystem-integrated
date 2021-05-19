package com.coronaconsultation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coronaconsultation.entities.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

}
