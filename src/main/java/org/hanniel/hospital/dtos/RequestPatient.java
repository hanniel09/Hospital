package org.hanniel.hospital.dtos;

import java.util.List;

public class RequestPatient {
    private List<Long> patientId;

    public List<Long> getPatientId() {
        return patientId;
    }

    public void setPatientId(List<Long> patientId) {
        this.patientId = patientId;
    }
}
