package com.example.doctorAppointment.ENTITIES;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Patient {
    private String name;
    private List<Appointment> appointmentList;
}
