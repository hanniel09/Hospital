package org.hanniel.hospital.services;

import jakarta.transaction.Transactional;
import org.hanniel.hospital.domain.Doctor;
import org.hanniel.hospital.dtos.DoctorDTO;
import org.hanniel.hospital.exceptions.BadRequestException;
import org.hanniel.hospital.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    public List<Doctor> findAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor findDoctorById(Long id) {
        return doctorRepository.findById(id).orElseThrow(() ->
                new BadRequestException("Doctor", id)
        );
    }

    @Transactional
    public Doctor createDoctor(DoctorDTO data) {
        Doctor doctor = new Doctor(data);
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctor(DoctorDTO data, Long id) {
        Doctor oldDoctor = findDoctorById(id);
        Doctor newDoctor = new Doctor(data);
        newDoctor.setId(oldDoctor.getId());
        return doctorRepository.save(newDoctor);
    }

    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

}
