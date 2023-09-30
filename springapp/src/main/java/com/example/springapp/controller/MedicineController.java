package com.example.springapp.controller;

import com.example.springapp.Medicine;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class MedicineController {
    private Map<Integer, Medicine> medicineStore = new HashMap<>();
    private int nextMedicineId = 1;

    @PostMapping("/medicines")
    public ResponseEntity<Boolean> addMedicine(@RequestBody Medicine medicine) {
        if (medicine != null) {
            medicine.setMedicineId(nextMedicineId++);
            medicineStore.put(medicine.getMedicineId(), medicine);
            return new ResponseEntity<>(true, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/medicines/{medicineId}")
    public ResponseEntity<Medicine> updateMedicine(@PathVariable int medicineId, @RequestBody Medicine updatedMedicine) {
        if (medicineStore.containsKey(medicineId) && updatedMedicine != null) {
            updatedMedicine.setMedicineId(medicineId);
            medicineStore.put(medicineId, updatedMedicine);
            return new ResponseEntity<>(updatedMedicine, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
