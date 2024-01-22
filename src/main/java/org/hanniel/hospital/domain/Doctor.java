package org.hanniel.hospital.domain;

import jakarta.persistence.*;
import org.hanniel.hospital.dtos.DoctorDTO;

@Table
@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long DVC;

    @Column
    private String name;

    @Column
    private String specialty;

    @Column
    private String room;

    public Doctor() {
    }

    public Doctor(DoctorDTO data) {
        this.DVC = data.DVC();
        this.name = data.name();
        this.specialty = data.specialty();
        this.room = data.room();
    }

    public Doctor(Long DVC, String name, String specialty, String room) {
        this.DVC = DVC;
        this.name = name;
        this.specialty = specialty;
        this.room = room;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDVC() {
        return DVC;
    }

    public void setDVC(Long DVC) {
        this.DVC = DVC;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
