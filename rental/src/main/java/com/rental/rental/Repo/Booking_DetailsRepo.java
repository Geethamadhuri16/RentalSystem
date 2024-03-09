package com.rental.rental.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rental.rental.Model.BookingDetails;

public interface Booking_DetailsRepo extends JpaRepository<BookingDetails, Long> {


}
