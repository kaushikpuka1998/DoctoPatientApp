package com.example.doctorAppointment.SERVICES;

import com.example.doctorAppointment.ENTITIES.Doctor;
import com.example.doctorAppointment.ENTITIES.Slot;
import com.example.doctorAppointment.ENTITIES.Speciality;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DoctorService {
    Map<String, Doctor> doctors = new HashMap<>();

    public String registerDoctor(Doctor doctor) {
        if (doctors.containsKey(doctor.getName())) {
            return "Doctor already exists";
        }
        Doctor newDoctor = new Doctor(doctor.getName(), doctor.getSpeciality());
        doctors.put(doctor.getName(), newDoctor);
        return "Welcome " + doctor.getName()+"!!";
    }

    public String markAvailable(String doctorName, List<Slot> slots) {
        Doctor doctor = doctors.get(doctorName);
        if (doctor == null) {
            return "Doctor not found";
        }
        for(Slot s:slots){
           if(s.getEndTime().minusHours(1).isAfter(s.getStartTime())){
               return "Slot duration should be 1 hour";
           }
           s.setAvailable(true);
           doctor.getAvailableSlots().add(s);
        }

        return "Done doc!!";
    }

    public List<Doctor> getDoctsBySpeciality(Speciality speciality) {
        List<Doctor> docs = new ArrayList<>();
        for (Doctor d : doctors.values()) {
            if (d.getSpeciality().equals(speciality)) {
                {
                    docs.add(d);
                }
            }
        }
        return docs;
    }

    public Doctor getDoctorByName(String name){
        return doctors.get(name);
    }
}
