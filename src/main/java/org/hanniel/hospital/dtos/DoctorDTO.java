package org.hanniel.hospital.dtos;

import jakarta.validation.constraints.NotNull;

public record DoctorDTO(
        @NotNull
        Long DVC,
        @NotNull
        String name,
        @NotNull
        String specialty,
        @NotNull
        String room) {

}
