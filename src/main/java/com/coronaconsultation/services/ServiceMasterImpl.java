package com.coronaconsultation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coronaconsultation.entities.Services;
import com.coronaconsultation.repository.ServicesRepository;

@Service
public class ServiceMasterImpl implements IServiceMaster{
	@Autowired
	private ServicesRepository servicesRepository;

	@Override
	public boolean AddService(Services services) {
		// TODO Auto-generated method stub
		servicesRepository.save(services);
		return true;
	}

	@Override
	public Services GetService(int id) {
		// TODO Auto-generated method stub
		
		return servicesRepository.findById(id).get();
	}

}
