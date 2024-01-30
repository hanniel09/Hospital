package org.hanniel.hospital.domain;

import jakarta.persistence.*;
import org.hanniel.hospital.dtos.UrgencyQueueDTO;

import java.util.List;
import java.util.Set;

@Entity
@Table
public class UrgencyQueue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private List<Long> patients;

    public UrgencyQueue() {
    }

    public UrgencyQueue(String name, List<Long> patients) {
        this.name = name;
        this.patients = patients;
    }

    public UrgencyQueue(UrgencyQueueDTO data) {
        this.name = data.name();
        this.patients = data.patients();
    }

    public UrgencyQueue(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getPatients() {
        return patients;
    }

    public void setPatients(List<Long> patientList) {
        this.patients = patientList;
    }
}
