package org.hanniel.hospital.repositories;

import org.hanniel.hospital.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    Optional<Doctor> findDoctorByName(String name);

    Optional<Doctor> findDoctorByDVC(Long DVC);
}
