package com.coronaconsultation.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class WardReport {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int wardReportId;
@Column(name = "description", length = 50)
private String description;

@Column(name = "dateOfReport",  nullable = true)
private LocalDate dateOfReport;


@OneToOne
@JoinColumn(name = "ward_id", referencedColumnName = "ward_id")
private Ward ward;
}