package com.example.springapp;

import .Medicine;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/medicines")
public class MedicineController {
    private Map<Integer, Medicine> medicineStore = new HashMap<>();
    private int nextMedicineId = 1;

    @PostMapping
    public boolean addMedicine(@RequestBody Medicine medicine) {
        if (medicine != null) {
            medicine.setMedicineId(nextMedicineId++);
            medicineStore.put(medicine.getMedicineId(), medicine);
            return true;
        }
        return false;
    }

    @PutMapping("/{medicineId}")
    public Medicine updateMedicine(@PathVariable int medicineId, @RequestBody Medicine updatedMedicine) {
        if (medicineStore.containsKey(medicineId) && updatedMedicine != null) {
            updatedMedicine.setMedicineId(medicineId);
            medicineStore.put(medicineId, updatedMedicine);
            return updatedMedicine;
        }
        return null;
    }

    @GetMapping
    public List<Medicine> getAllMedicines() {
        return new ArrayList<>(medicineStore.values());
    }
}
