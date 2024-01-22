package org.hanniel.hospital.dtos;

import org.hanniel.hospital.domain.Doctor;

import java.util.List;

public record PatientDTO(Long attendanceSheet, String name, String symptoms,
                         String queuePriority, String medicine, List<Doctor> doctorList, String description) {
}
