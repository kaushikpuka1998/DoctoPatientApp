package com.example.doctorAppointment.INTERFACES;

import com.example.doctorAppointment.ENTITIES.Slot;

import java.util.List;

public interface SlotRankingStategy {
    List<Slot> rankSlots(List<Slot> slots);

}
