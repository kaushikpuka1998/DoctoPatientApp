package com.example.doctorAppointment.SERVICES;

import com.example.doctorAppointment.ENTITIES.Appointment;
import com.example.doctorAppointment.ENTITIES.Doctor;
import com.example.doctorAppointment.ENTITIES.Patient;
import com.example.doctorAppointment.ENTITIES.Slot;
import com.example.doctorAppointment.INTERFACES.SlotRankingStategy;
import com.example.doctorAppointment.INTERFACE_IMPLEMENTATION.StartTimeRankStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PatientService {

    Map<String, Patient> patients = new HashMap<>();
    @Autowired
    DoctorService doctorService;

    private SlotRankingStategy slotRankingStrategy = new StartTimeRankStrategy();


    public String registerPatient(Patient patient) {
        if (patients.containsKey(patient.getName())) {
            return "Patient already exists";
        }
        patients.put(patient.getName(), patient);
        return "Welcome " + patient.getName()+"!!";
    }

    public String bookAppointMent(String patientName,String doctorName, LocalTime startTime){
        Patient patient = patients.get(patientName);
        Doctor doctor = doctorService.getDoctorByName(doctorName);
        if (patient == null || doctor == null) {
            return "Patient or Doctor not found";
        }
        for(Slot slot:doctor.getAvailableSlots()){
            if(slot.getStartTime().equals(startTime) && slot.isAvailable()){
                Appointment appointment = new Appointment(doctor,slot,patient);
                patient.getAppointmentList().add(appointment);
                slot.setAvailable(false);
                return "Appointment booked successfully, BookingID: " + appointment.getId();
            }
        }

        return "Slot not available";
    }

    public String cancelAppointment(String patientName,String doctorName, LocalTime startTime){
        Patient patient = patients.get(patientName);
        Doctor doctor = doctorService.getDoctorByName(doctorName);
        if (patient == null || doctor == null) {
            return "Patient or Doctor not found";
        }
        for(Slot slot:doctor.getAvailableSlots()){
            if(slot.getStartTime().equals(startTime) && !slot.isAvailable()){
                Appointment appointment = patient.getAppointmentList().stream().filter(a -> a.getDoctor().equals(doctor) && a.getSlot().equals(slot)).findFirst().get();
                patient.getAppointmentList().remove(appointment);
                slot.setAvailable(true);
                return "Appointment cancelled successfully, BookingID: " + appointment.getId();
            }
        }

        return "Appointment not found";
    }

    public List<Slot> getAllSlots(String doctorName){
        return slotRankingStrategy.rankSlots(doctorService.getDoctorByName(doctorName).getAvailableSlots());
    }

}
