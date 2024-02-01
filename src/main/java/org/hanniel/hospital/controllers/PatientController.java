package org.hanniel.hospital.controllers;

import org.hanniel.hospital.domain.Doctor;
import org.hanniel.hospital.domain.Patient;
import org.hanniel.hospital.dtos.PatientDTO;
import org.hanniel.hospital.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    PatientService patientService;

    @GetMapping()
    public ResponseEntity<List<Patient>> getAllPatients() {
        return new ResponseEntity<>(patientService.getAllPatient(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Patient> findPatientById(@PathVariable Long id) {
        return new ResponseEntity<>(patientService.findPatientById(id), HttpStatus.OK);
    }

    @GetMapping(path = "/byName/{name}")
    public ResponseEntity<Patient> findPatientByName(@PathVariable String name){
        return new ResponseEntity<>(patientService.findPatientByName(name), HttpStatus.OK);
    }

    @GetMapping(path = "/byFichteNumber/{attendanceSheet}")
    public ResponseEntity<Patient> findPatientByAttendanceSheet(@PathVariable Long attendanceSheet){
        return new ResponseEntity<>(patientService.findPatientByAttendanceSheet(attendanceSheet), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Patient> createPatient(@RequestBody PatientDTO data) {
        return new ResponseEntity<>(patientService.createPatient(data), HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Patient> updatePatient(@RequestBody PatientDTO data, @PathVariable Long id) {
        return new ResponseEntity<>(patientService.updatePatient(data, id), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
