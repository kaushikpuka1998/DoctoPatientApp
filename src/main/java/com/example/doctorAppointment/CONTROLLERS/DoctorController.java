package com.example.doctorAppointment.CONTROLLERS;

import com.example.doctorAppointment.ENTITIES.Doctor;
import com.example.doctorAppointment.ENTITIES.Slot;
import com.example.doctorAppointment.ENTITIES.Speciality;
import com.example.doctorAppointment.SERVICES.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping("/register")
    public String registerDoctor(@RequestBody Doctor doctor) {
        return doctorService.registerDoctor(doctor);
    }

    @PostMapping("/markAvailable")
    public String markAvailable(@RequestParam String doctorName, @RequestBody List<Slot> slots) {
        return doctorService.markAvailable(doctorName, slots);
    }

    @GetMapping("/getBySpeciality")
    public List<Doctor> getDoctorsBySpeciality(@RequestParam Speciality speciality) {
        return doctorService.getDoctsBySpeciality(speciality);
    }
}
