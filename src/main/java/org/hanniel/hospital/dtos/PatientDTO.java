package org.hanniel.hospital.dtos;

import org.hanniel.hospital.domain.Doctor;

public record PatientDTO(Long attendanceSheet, String name, String symptoms,
                         String queuePriority, String medicine, Doctor doctor, String description) {
}
