package com.coronaconsultation.services;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.coronaconsultation.entities.Gender;
import com.coronaconsultation.entities.Patient;
import com.coronaconsultation.entities.Services;
import com.coronaconsultation.repository.ServicesRepository;

@SpringBootTest
public class ServicesMasterImplTest {
@Autowired
private IServiceMaster serviceMaster;
@Autowired
private IPatientServices patientServices;
@MockBean
private ServicesRepository servicesRepository;
@Test

void createServicesTest() throws Exception {
		Patient patient = new Patient();
		patient.setPatientid(1);
		patient.setGender(Gender.MALE);
		patient.setEmail("neetu@gmail.com");
		patient.setLocation("Delhi");
		patient.setMobile("7896541230");
		patient.setName("Neetu Singh");
		patient.setTreatment(null);
		patient.setDoctorReport(null);
		patient.setFeedback(null);
		patient.setPatientReport(null);
		patient.setService(null);
		
		Services s = new Services();
		s.setId(1);;
		s.setPatient(null);
		s.setPatient(patient);
		s.setAdditionalServices(null);
		s.setIPD(null);
		s.setOPD(null);
		when(servicesRepository.save(s)).thenReturn(s);
		Boolean userToBeAdded = serviceMaster.AddService(s);
		assertEquals(true, userToBeAdded);
		
	}



@Test
void getServicesTest() throws Exception {
	Services services= new Services();
			services.setIPD(true);
			services.setOPD(false);
			services.setAdditionalServices("Ambulance");
	assertFalse(servicesRepository.existsById(1));
}

}





