package com.example.springapp;

public class Medicine {
    private int medicineId;
    private String medicineName;
    private float price;
    private int quantity;
    private String description;

    public Medicine() {
    }

    public Medicine(int medicineId, String medicineName, float price, int quantity, String description) {
        this.medicineId = medicineId;
        this.medicineName = medicineName;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    // Getters and setters
}
