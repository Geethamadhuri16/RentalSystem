package com.rental.rental.Model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity 
@Data
public class BookingDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long booking_Id;
	private Date rentalDate;
	private Date submittedDate;
	private String userName;
	private String aadharnum;
	private String drivingLicenceNum;
	private int days;
	private String Mobilenum;
	private String paymentType;
	private String paymentMode;
	private String vehicleType;
	private String registrationNumber;
	private int fine;

}