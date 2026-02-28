package com.coronaconsultation.entities;

import jakarta.persistence.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

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
	
	@OneToOne(mappedBy = "ward", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private WardReport wardReport;

}