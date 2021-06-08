package com.coronaconsultation.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

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