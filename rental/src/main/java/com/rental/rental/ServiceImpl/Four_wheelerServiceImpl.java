package com.rental.rental.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.rental.rental.Model.Four_wheeler;
import com.rental.rental.Repo.Four_wheelerRepo;
import com.rental.rental.Service.Four_wheelerService;

@Service
public class Four_wheelerServiceImpl implements Four_wheelerService {

    @Autowired
    private Four_wheelerRepo fourWheelerRepository;

    public ResponseEntity<Four_wheeler> createFourWheeler(Four_wheeler fourWheeler) {
        try {
            Four_wheeler savedFourWheeler = fourWheelerRepository.save(fourWheeler);
            return new ResponseEntity<>(savedFourWheeler, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Iterable<Four_wheeler>> getAllFourWheelers() {
        try {
            Iterable<Four_wheeler> fourWheelers = fourWheelerRepository.findAll();
            return new ResponseEntity<>(fourWheelers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Four_wheeler> getFourWheelerById(Long id) {
        try {
            Four_wheeler fourWheeler = fourWheelerRepository.findById(id).orElse(null);
            if (fourWheeler == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(fourWheeler, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Four_wheeler> updateFourWheeler(Long id, Four_wheeler updatedFourWheeler) {
        try {
            if (fourWheelerRepository.existsById(id)) {
                updatedFourWheeler.setId(id); // Ensure the ID is set for the updated entity
                Four_wheeler savedFourWheeler = fourWheelerRepository.save(updatedFourWheeler);
                return new ResponseEntity<>(savedFourWheeler, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<HttpStatus> deleteFourWheeler(Long id) {
        try {
            fourWheelerRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
