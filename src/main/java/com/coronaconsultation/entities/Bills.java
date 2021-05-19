package com.coronaconsultation.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Bills {
@Id
@GeneratedValue(strategy =  GenerationType.SEQUENCE)
private int id;
private String Pname;
private Float Total;

}
