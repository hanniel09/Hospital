package org.hanniel.hospital.repositories;

import org.hanniel.hospital.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Optional<Patient> findPatientByName(String name);

    Optional<Patient> findPatientByAttendanceSheet(Long AttendanceSheet);
}
