package com.rental.rental.Service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.rental.rental.Model.Two_wheeler;

public interface Two_wheelerService {
	 public ResponseEntity<Long> createTwoWheeler(Two_wheeler twoWheeler);
	 public ResponseEntity<List<Two_wheeler>> getAllTwoWheelers() ;
	 public ResponseEntity<Two_wheeler> getTwoWheelerById(Long id) ;
	 public ResponseEntity<Two_wheeler> updateTwoWheeler(Long id, Two_wheeler updatedTwoWheeler);
	 public ResponseEntity<HttpStatus> deleteTwoWheeler(Long id);

}
