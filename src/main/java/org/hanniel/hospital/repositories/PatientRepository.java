package org.hanniel.hospital.repositories;

import org.hanniel.hospital.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
