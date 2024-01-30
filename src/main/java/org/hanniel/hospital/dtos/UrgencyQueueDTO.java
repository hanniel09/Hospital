package org.hanniel.hospital.dtos;

import org.hanniel.hospital.domain.Patient;

import java.util.List;
import java.util.Set;

public record UrgencyQueueDTO(String name, List<Long> patients) {

}
