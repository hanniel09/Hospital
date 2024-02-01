package org.hanniel.hospital.services;

import jakarta.transaction.Transactional;
import org.hanniel.hospital.domain.Doctor;
import org.hanniel.hospital.dtos.DoctorDTO;
import org.hanniel.hospital.exceptions.BadRequestException;
import org.hanniel.hospital.exceptions.RecordByNameNotFoundException;
import org.hanniel.hospital.exceptions.RecordNotFoundException;
import org.hanniel.hospital.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    public List<Doctor> findAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor findDoctorByName(String name){
        return doctorRepository.findDoctorByName(name).orElseThrow(() ->
                new RecordByNameNotFoundException("Doctor", name));
    }


    public Doctor findDoctorById(Long id) {
        return doctorRepository.findById(id).orElseThrow(() ->
                new BadRequestException("Doctor", id)
        );
    }

    public Doctor findDoctorByDVC(Long DVC){
        return doctorRepository.findDoctorByDVC(DVC).orElseThrow(() ->
                new RecordNotFoundException("Doctor", DVC));
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
