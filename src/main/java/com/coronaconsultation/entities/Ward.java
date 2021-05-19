package com.coronaconsultation.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Ward {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int ward_id;
	private String ward_name;
	private int ward_floor;
	private boolean oxygen_availability;
	private boolean vacancy_status;
	
	@OneToOne(mappedBy = "ward", cascade = CascadeType.ALL)
	@JoinTable(name = "ward_and_reports", joinColumns = {
			@JoinColumn(name = "ward_id", nullable = true, referencedColumnName = "ward_id") }, inverseJoinColumns = {
					@JoinColumn(name = "ward_report_id", nullable = true, referencedColumnName = "wardReportId") })
	
	//@JoinColumn(name = "wardReport_id", referencedColumnName = "wardReportId")
	private WardReport wardReport;

}