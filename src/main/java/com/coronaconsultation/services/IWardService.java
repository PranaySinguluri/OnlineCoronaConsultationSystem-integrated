package com.coronaconsultation.services;

import com.coronaconsultation.entities.Ward;

public interface IWardService {

	public boolean createWard(Ward ward);

	public boolean updateWard(Ward ward);

	public Ward findById(int id);

}
