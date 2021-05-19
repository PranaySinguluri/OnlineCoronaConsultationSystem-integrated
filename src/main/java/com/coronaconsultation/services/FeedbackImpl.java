package com.coronaconsultation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coronaconsultation.entities.Feedback;
import com.coronaconsultation.repository.FeedbackRepository;
@Service
public class FeedbackImpl implements IFeedback{
	@Autowired
	FeedbackRepository feedbackRepository;
	@Override
	public boolean createFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		feedbackRepository.save(feedback);
		return false;
	}
	

}
