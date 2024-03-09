package com.rental.rental.Model;

import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data
@MappedSuperclass
public class Vehicle {
	
	private String make;
	private String model;
	private int year;
	private String VIN;
	private String registrationNumber;
	private String registrationDate;
	private double mileage;
	private String fuelType;
	private String insuranceProvider;
	private String insuranceExpirationDate;
	private double maxSpeed; 
	private String wheelType;
	private boolean Available;

}