package com.rental.rental.Controller;



import com.rental.rental.Model.Four_wheeler;
import com.rental.rental.Service.Four_wheelerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/four-wheelers")
public class Four_WheelerController {

    @Autowired
    private Four_wheelerService fourWheelerService;

    @PostMapping
    public ResponseEntity<Four_wheeler> createFourWheeler(@RequestBody Four_wheeler fourWheeler) {
        return fourWheelerService.createFourWheeler(fourWheeler);
    }

    @GetMapping
    public ResponseEntity<Iterable<Four_wheeler>> getAllFourWheelers() {
        return fourWheelerService.getAllFourWheelers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Four_wheeler> getFourWheelerById(@PathVariable("id") Long id) {
        return fourWheelerService.getFourWheelerById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Four_wheeler> updateFourWheeler(@PathVariable("id") Long id,
                                                          @RequestBody Four_wheeler updatedFourWheeler) {
        return fourWheelerService.updateFourWheeler(id, updatedFourWheeler);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteFourWheeler(@PathVariable("id") Long id) {
        return fourWheelerService.deleteFourWheeler(id);
    }
}
