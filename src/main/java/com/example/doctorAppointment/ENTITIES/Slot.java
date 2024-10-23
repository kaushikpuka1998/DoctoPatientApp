package com.example.doctorAppointment.ENTITIES;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Slot {
    private LocalTime startTime;
    private LocalTime endTime;
    private boolean isAvailable;

    public Slot(LocalTime startTime, LocalTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.isAvailable = true;
    }
}
