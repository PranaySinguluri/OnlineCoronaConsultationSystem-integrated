package com.coronaconsultation.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

// Jackson
import com.fasterxml.jackson.annotation.JsonIgnore;

// Lombok
import lombok.Data;

@Entity
@Data
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Doctor_Name")
    @NotNull(message = "Name Should Not be Null")
    private String name;

    @Column(nullable = false)
    private String specialization;

    @Column(name = "email", nullable = false)
    @NotNull(message = "Doctor Mail is Compulsory")
    @Email
    private String email;

    @Column(name = "Mobile_Number")
    @Pattern(regexp = "^[6-9][0-9]{9}$", message = "Enter Valid Mobile Number")
    private String mobile;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @JsonIgnore
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Treatment> treatement;

    @JsonIgnore
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PatientReport> patientReport;

    @JsonIgnore
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DoctorReport> doctorReport;
}