package com.coronaconsultation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coronaconsultation.entities.Feedback;
import com.coronaconsultation.services.FeedbackImpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
@RestController
@RequestMapping("/api/feedback/")
public class FeedbackController {
	@Autowired
	FeedbackImpl feedbackImpl;
	@PostMapping("/")
	public ResponseEntity<String> CreateFeedback(@RequestBody Feedback feedback){
		feedbackImpl.createFeedback(feedback);
		return new ResponseEntity<>("Feedback Submitted",HttpStatus.OK);
	}

}
