package com.rental.rental.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rental.rental.Model.Two_wheeler;
import com.rental.rental.Repo.Two_wheelerRepo;
import com.rental.rental.Service.Two_wheelerService;

import java.util.List;
import java.util.Optional;

@Service
public class TwoWheelerServiceImpl implements Two_wheelerService {

    @Autowired
    private Two_wheelerRepo twoWheelerRepository;

    
    // Create operation
    public ResponseEntity<Long> createTwoWheeler(Two_wheeler twoWheeler) {
        try {
            twoWheelerRepository.save(twoWheeler);
            return new ResponseEntity<>(twoWheeler.getId(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Read operation
    public ResponseEntity<List<Two_wheeler>> getAllTwoWheelers() {
        try {
            List<Two_wheeler> twoWheelers = twoWheelerRepository.findAll();
            return new ResponseEntity<>(twoWheelers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Two_wheeler> getTwoWheelerById(Long id) {
        try {
            Optional<Two_wheeler> twoWheeler = twoWheelerRepository.findById(id);
            return twoWheeler.map(w -> new ResponseEntity<>(w, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update operation
    public ResponseEntity<Two_wheeler> updateTwoWheeler(Long id, Two_wheeler updatedTwoWheeler) {
        try {
            if (twoWheelerRepository.existsById(id)) {
                updatedTwoWheeler.setId(id);
                Two_wheeler savedTwoWheeler = twoWheelerRepository.save(updatedTwoWheeler);
                return new ResponseEntity<>(savedTwoWheeler, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete operation
    public ResponseEntity<HttpStatus> deleteTwoWheeler(Long id) {
        try {
            if (twoWheelerRepository.existsById(id)) {
                twoWheelerRepository.deleteById(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
