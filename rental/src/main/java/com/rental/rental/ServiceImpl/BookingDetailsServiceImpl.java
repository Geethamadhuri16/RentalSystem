package com.rental.rental.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rental.rental.Model.BookingDetails;

import com.rental.rental.Repo.Booking_DetailsRepo;
import com.rental.rental.Repo.Four_wheelerRepo;
import com.rental.rental.Repo.Two_wheelerRepo;
import com.rental.rental.Service.BookingDetailsService;

@Service
public class BookingDetailsServiceImpl implements BookingDetailsService {

	@Autowired
	private Booking_DetailsRepo repo;

	@Autowired
	private Two_wheelerRepo trepo;

	@Autowired
	private Four_wheelerRepo frepo;


	@Override
	public ResponseEntity<Long> addBooking(BookingDetails b) {
		String regnum=b.getRegistrationNumber();
		try {
			if(b.getVehicleType().equals("four_wheeler")) {
				if(frepo.findByRegistrationNumber(regnum)!=null) {
					if(frepo.findByRegistrationNumber(regnum).isAvailable()==false) {
						return new ResponseEntity<>(null,HttpStatus.NOT_ACCEPTABLE);
					}
					repo.save(b);
					return new ResponseEntity<>(frepo.findByRegistrationNumber(regnum).getId(),HttpStatus.NOT_ACCEPTABLE);
				}else {
					return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
				}

			}else {

				if(trepo.findByRegistrationNumber(regnum)!=null) {
					if(trepo.findByRegistrationNumber(regnum).isAvailable()==false) {
						return new ResponseEntity<>(null,HttpStatus.NOT_ACCEPTABLE);
					}
					repo.save(b);
					return new ResponseEntity<>(trepo.findByRegistrationNumber(regnum).getId(),HttpStatus.NOT_ACCEPTABLE);

				}else {
					return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
				}

			}
		}catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Long> cancelBooking(long id) {
		try {
			BookingDetails b=repo.getById(id);
			if(b.getVehicleType().equals("four_wheeler")) {
				frepo.findByRegistrationNumber(b.getRegistrationNumber()).setAvailable(true);
				repo.deleteById(id);
				return new ResponseEntity<>(id,HttpStatus.OK);
			}else {
				trepo.findByRegistrationNumber(b.getRegistrationNumber()).setAvailable(true);
				repo.deleteById(id);
				return new ResponseEntity<>(id,HttpStatus.OK);
			}
		}catch(Exception e){
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	
	@Override
	public ResponseEntity<BookingDetails> updateBooking(Long id, BookingDetails booking) {
	    try {
	        BookingDetails bd = repo.findById(id).orElse(null);
	        if (bd != null ) {
	            if (booking.getVehicleType().equals("four_wheeler")) {
	                if (frepo.findByRegistrationNumber(booking.getRegistrationNumber()) != null) {
	                    if (!frepo.findByRegistrationNumber(booking.getRegistrationNumber()).isAvailable()) {
	                        return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
	                    }
	                    bd.setRegistrationNumber(booking.getRegistrationNumber());
	                    bd.setDays(booking.getDays());
	                    bd.setMobilenum(booking.getMobilenum());
	                    bd.setVehicleType(booking.getVehicleType());
	                    repo.save(bd);
	                    return new ResponseEntity<>(bd, HttpStatus.OK);
	                } else {
	                    return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	                }
	            } else {
	                if (trepo.findByRegistrationNumber(booking.getRegistrationNumber()) != null) {
	                    if (!trepo.findByRegistrationNumber(booking.getRegistrationNumber()).isAvailable()) {
	                        return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
	                    }
	                    bd.setRegistrationNumber(booking.getRegistrationNumber());
	                    bd.setDays(booking.getDays());
	                    bd.setMobilenum(booking.getMobilenum());
	                    bd.setVehicleType(booking.getVehicleType());
	                    repo.save(bd);
	                    return new ResponseEntity<>(bd, HttpStatus.OK);
	                } else {
	                    return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	                }
	            }
	        } else {
	            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	        }
	    } catch (Exception e) {
	        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}


	@Override
	public ResponseEntity<List<BookingDetails>> allBookings() {
		try {
			if(repo.findAll()!=null) {
				return new ResponseEntity<>(repo.findAll(),HttpStatus.OK);
			}else {
				return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);

			}
		}catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}
