package com.example.doctorAppointment.INTERFACE_IMPLEMENTATION;

import com.example.doctorAppointment.ENTITIES.Slot;
import com.example.doctorAppointment.INTERFACES.SlotRankingStategy;

import java.util.Comparator;
import java.util.List;

public class StartTimeRankStrategy implements SlotRankingStategy {
    @Override
    public List<Slot> rankSlots(List<Slot> slots) {
        return slots.stream().sorted(Comparator.comparing(Slot::getStartTime))
                .toList();
    }
}
