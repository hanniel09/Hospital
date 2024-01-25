package org.hanniel.hospital.domain;

import jakarta.persistence.*;
import org.hanniel.hospital.dtos.PatientDTO;

import java.util.List;

@Entity
@Table
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long attendanceSheet;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String symptoms;

    @Column(nullable = false)
    private String queuePriority;


    private String medicine;


    /*
    * Bug: When I create a List of doctors, the api create a new Doctor and no find the doctor with his id
    */

    @ManyToMany
    @JoinTable(name = "ResponsibleDoctor",
            joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "doctor_id"))
    private List<Doctor> doctorList;

    private String description;

    public Patient() {
    }

    public Patient(PatientDTO data) {
        this.attendanceSheet = data.attendanceSheet();
        this.name = data.name();
        this.symptoms = data.symptoms();
        this.queuePriority = data.queuePriority();
        this.medicine = data.medicine();
        this.doctorList = data.doctorList();
        this.description = data.description();
    }

    public Patient(Long attendanceSheet, String name, String symptoms, String queuePriority, String medicine, List<Doctor> doctor, String description) {
        this.attendanceSheet = attendanceSheet;
        this.name = name;
        this.symptoms = symptoms;
        this.queuePriority = queuePriority;
        this.medicine = medicine;
        this.doctorList = doctor;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAttendanceSheet() {
        return attendanceSheet;
    }

    public void setAttendanceSheet(Long attendanceSheet) {
        this.attendanceSheet = attendanceSheet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getQueuePriority() {
        return queuePriority;
    }

    public void setQueuePriority(String queuePriority) {
        this.queuePriority = queuePriority;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public List<Doctor> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(List<Doctor> doctor) {
        this.doctorList = doctor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
