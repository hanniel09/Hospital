package org.hanniel.hospital.services;

import jakarta.transaction.Transactional;
import org.hanniel.hospital.domain.Doctor;
import org.hanniel.hospital.domain.Patient;
import org.hanniel.hospital.dtos.PatientDTO;
import org.hanniel.hospital.exceptions.BadRequestException;
import org.hanniel.hospital.exceptions.RecordByNameNotFoundException;
import org.hanniel.hospital.exceptions.RecordNotFoundException;
import org.hanniel.hospital.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    DoctorService doctorService;

    public List<Patient> getAllPatient() {
        return patientRepository.findAll();
    }

    public Patient findPatientById(Long id) {
        return patientRepository.findById(id).orElseThrow(() ->
                new BadRequestException("Patient", id)
        );
    }

    public Patient findPatientByName(String name) {
        return patientRepository.findPatientByName(name).orElseThrow(() ->
                new RecordByNameNotFoundException("Patient", name)
        );
    }

    public Patient findPatientByAttendanceSheet(Long attendanceSheet){
        return patientRepository.findPatientByAttendanceSheet(attendanceSheet).orElseThrow(() ->
                new RecordNotFoundException("Patient", attendanceSheet)
        );
    }

    @Transactional
    public Patient createPatient(PatientDTO data) {
        Patient patient = new Patient(data);
        Doctor doctor = doctorService.findDoctorById(data.doctor().getId());
        patient.setDoctor(doctor);
        return patientRepository.save(patient);
    }

    public Patient updatePatient(PatientDTO data, Long id) {
        Patient oldPatient = findPatientById(id);
        Patient newPatient = new Patient(data);
        newPatient.setId(oldPatient.getId());
        return patientRepository.save(newPatient);
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
