package com.example.doctorAppointment.CONTROLLERS;

import com.example.doctorAppointment.ENTITIES.Patient;
import com.example.doctorAppointment.ENTITIES.Slot;
import com.example.doctorAppointment.ENTITIES.Speciality;
import com.example.doctorAppointment.SERVICES.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/register")
    public String registerPatient(@RequestBody Patient patient) {
        return patientService.registerPatient(patient);
    }

    @PostMapping("/bookAppointment")
    public String bookAppointment(@RequestParam String patientName, @RequestParam String doctorName, @RequestParam String startTime) {
        LocalTime time = LocalTime.parse(startTime);
        return patientService.bookAppointMent(patientName, doctorName, time);
    }

    @PostMapping("/cancelAppointment")
    public String cancelAppointment(@RequestParam String patientName, @RequestParam String doctorName, @RequestParam String startTime) {
        LocalTime time = LocalTime.parse(startTime);
        return patientService.cancelAppointment(patientName, doctorName, time);
    }

    @GetMapping("/getAllSlots")
    public List<Slot> getAllSlots(@RequestParam String doctorName) {
        return patientService.getAllSlots(doctorName);
    }
}
