package com.coronaconsultation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coronaconsultation.entities.Ward;
import com.coronaconsultation.exception.WardException;
import com.coronaconsultation.repository.WardRepository;

@Service
public class WardServiceImpl implements IWardService { 
	
	@Autowired
	private WardRepository wardRepository;

	@Override
	public boolean createWard(Ward ward) {
		
		wardRepository.save(ward);
		
		return false;
	}

	@Override
	public boolean updateWard(Ward ward) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Ward findById(int id)  {
		if(!wardRepository.existsById(id)) {
			throw new WardException("Ward Not Found");
		}
		
		Ward e =  wardRepository.findById(id).get();
		return e;
	}

}
