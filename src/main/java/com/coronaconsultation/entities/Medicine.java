package com.coronaconsultation.entities;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Entity

@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "medicineId", scope = Integer.class)
public class Medicine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	
	private int medicineId;

	@Column(nullable= false)
	private String medicineName;
	
	
	@Column(nullable= false)
 
	private int price;
	

	@Column(name = "manufactureDate", length = 15)
	@NotNull(message = "manufactureDate should not be Empty")
	private LocalDate manufactureDate;
	


	@Column(name = "expiryDate", length = 15)
	@NotNull(message = "expiryDate should not be Empty")
	private LocalDate expiryDate;
	
	@Column(nullable= false)
	
	private int medicineStock;

	public Medicine(int medicineId, String medicineName, int price, LocalDate manufactureDate, LocalDate expiryDate,
			int medicineStock) {
		super();
		this.medicineId = medicineId;
		this.medicineName = medicineName;
		this.price = price;
		this.manufactureDate = manufactureDate;
		this.expiryDate = expiryDate;
		this.medicineStock = medicineStock;
	}

	public Medicine(int medicineId, String name, int price) {
		super();
		this.medicineId = medicineId;
		this.medicineName = medicineName;
		this.price = price;
	}

	public Medicine() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
