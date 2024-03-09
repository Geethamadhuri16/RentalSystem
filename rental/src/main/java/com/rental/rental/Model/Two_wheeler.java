package com.rental.rental.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Two_wheeler extends Vehicle {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private boolean hasKickStart;
	private boolean hasPillionSeat;
	private String handlebarType;
	private String chainType;
	private double fuelEfficiency;
	private boolean hasTopBox;
	private boolean hasSideStand;


}