package com.example.doctorAppointment.ENTITIES;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Random;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Appointment {
    private static int rank = 0;
    private int id;
    private Doctor doctor;
    private Slot slot;
    private Patient patient;

    public Appointment(Doctor doctor, Slot slot, Patient patient) {
        this.rank = new Random().nextInt(1000);
        this.id = rank;
        this.doctor = doctor;
        this.slot = slot;
        this.patient = patient;
    }
}
