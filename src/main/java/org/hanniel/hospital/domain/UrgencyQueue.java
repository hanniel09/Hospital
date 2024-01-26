package org.hanniel.hospital.domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table
public class UrgencyQueue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private Set<Patient> patients;

    public UrgencyQueue() {
    }

    public UrgencyQueue(String name, Set<Patient> patients) {
        this.name = name;
        this.patients = patients;
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

    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patientList) {
        this.patients = patientList;
    }
}
