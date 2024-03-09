package com.rental.rental.Controller;


import com.rental.rental.Model.Two_wheeler;
import com.rental.rental.Service.Two_wheelerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/two-wheelers")
public class Two_WheelerController {

    @Autowired
    private Two_wheelerService twoWheelerService;

    @PostMapping
    public ResponseEntity<Long> createTwoWheeler(@RequestBody Two_wheeler twoWheeler) {
        return twoWheelerService.createTwoWheeler(twoWheeler);
    }

    @GetMapping
    public ResponseEntity<List<Two_wheeler>> getAllTwoWheelers() {
        return twoWheelerService.getAllTwoWheelers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Two_wheeler> getTwoWheelerById(@PathVariable("id") Long id) {
        return twoWheelerService.getTwoWheelerById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Two_wheeler> updateTwoWheeler(@PathVariable("id") Long id,
                                                        @RequestBody Two_wheeler updatedTwoWheeler) {
        return twoWheelerService.updateTwoWheeler(id, updatedTwoWheeler);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTwoWheeler(@PathVariable("id") Long id) {
        return twoWheelerService.deleteTwoWheeler(id);
    }
}
