package com.rental.rental.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.rental.rental.Model.BookingDetails;

public interface BookingDetailsService {
	public ResponseEntity<Long> addBooking(BookingDetails b) ;
	public ResponseEntity<Long> cancelBooking(long id);
	public ResponseEntity<BookingDetails> updateBooking(Long id, BookingDetails booking);
	public ResponseEntity<List<BookingDetails>> allBookings();

}
