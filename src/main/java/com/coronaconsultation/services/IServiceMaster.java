package com.coronaconsultation.services;

import com.coronaconsultation.entities.Services;

public interface IServiceMaster {
public boolean AddService(Services services);
public Services GetService(int id);

}
