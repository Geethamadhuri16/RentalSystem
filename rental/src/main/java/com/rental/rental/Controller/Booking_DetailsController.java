package com.rental.rental.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rental.rental.Model.BookingDetails;
import com.rental.rental.Service.BookingDetailsService;

@RestController
@RequestMapping("/bookings")
public class Booking_DetailsController {

    @Autowired
    private BookingDetailsService bookingService;

    @PostMapping("/add")
    public ResponseEntity<Long> addBooking(@RequestBody BookingDetails bookingDetails) {
        return bookingService.addBooking(bookingDetails);
    }

    @DeleteMapping("/cancel/{id}")
    public ResponseEntity<Long> cancelBooking(@PathVariable("id") long id) {
        return bookingService.cancelBooking(id);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<BookingDetails> updateBooking(@PathVariable("id") Long id, @RequestBody BookingDetails bookingDetails) {
        return bookingService.updateBooking(id, bookingDetails);
    }

    @GetMapping("/all")
    public ResponseEntity<List<BookingDetails>> getAllBookings() {
        return bookingService.allBookings();
    }
}
