package com.rental.rental.Service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.rental.rental.Model.Four_wheeler;

public interface Four_wheelerService {
	public ResponseEntity<Four_wheeler> createFourWheeler(Four_wheeler fourWheeler);
	public ResponseEntity<Iterable<Four_wheeler>> getAllFourWheelers() ;
	public ResponseEntity<Four_wheeler> getFourWheelerById(Long id);
	public ResponseEntity<Four_wheeler> updateFourWheeler(Long id, Four_wheeler updatedFourWheeler) ;
	public ResponseEntity<HttpStatus> deleteFourWheeler(Long id);

}
