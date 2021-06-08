package com.coronaconsultation.services;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.coronaconsultation.entities.Medicine;
import com.coronaconsultation.entities.MedicineReport;
import com.coronaconsultation.repository.MedicineReportRepo;
import com.coronaconsultation.repository.MedicineRepository;
import com.coronaconsultation.services.MedicineReportServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class MedicineMasterControllerTest {
	@Autowired
	private MedicineRepository repo;
	Medicine med= new Medicine(1,"dolo", 67,LocalDate.of(2016, 8, 07),LocalDate.of(2016, 8, 07),89);
//    @Autowired
//   private  MedicineReport medicine;
	@Autowired
	private MedicineReportServiceImpl mrs;	
@Autowired
	private MedicineReportRepo report;
	
	MedicineReport med1= new MedicineReport();
	@Test
	public void savemed() {
	
         repo.save(med);
		assertTrue(repo.existsById(1));
    }
	@Test
	public  void findByid() {
		assertNotNull(repo.findById(1));
	}
	@Test
	public  void getByid() {
		assertNotNull(mrs.getPatientReports(1));
	}
	
	@Test
	public  void IsPresent() {
		assertTrue((repo.save(med).equals(med)));
	}

	@Test
	public void findreportId() {
		assertNotNull(report.findById(10));
    }
	
	@Test
	public void savetest() throws Exception {
		med1.setMedicineReportId(1);
//	when(report.save(med1)).thenReturn(med1);
	MedicineReport savetest= mrs.saveReport(med1);
	assertTrue(savetest.equals(med1));
		
	}
//	@Test
//	public void getAllTest() throws Exception {
//		
//	List<MedicineReport> list= mrs.getAllReports();
//	assertTrue(list.equals(report.findAll()));

		
//	}
	
	
}
