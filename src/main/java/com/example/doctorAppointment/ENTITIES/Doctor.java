package com.example.doctorAppointment.ENTITIES;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Doctor {
    private String name;
    private Speciality speciality;
    private List<Slot> availableSlots;
    private Double rating;

    public Doctor(String name, Speciality speciality) {
        this.name = name;
        this.speciality = speciality;
        this.availableSlots = new ArrayList<>();
        this.rating = 0.0;
    }
}
