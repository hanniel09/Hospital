package org.hanniel.hospital.repositories;

import org.hanniel.hospital.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
}
