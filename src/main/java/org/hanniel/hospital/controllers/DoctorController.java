package org.hanniel.hospital.controllers;

import org.hanniel.hospital.domain.Doctor;
import org.hanniel.hospital.dtos.DoctorDTO;
import org.hanniel.hospital.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @GetMapping()
    public ResponseEntity<List<Doctor>> findAllDoctors(){
        return new ResponseEntity<>(doctorService.findAllDoctors(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Doctor> findDoctorById(@PathVariable Long id){
        return new ResponseEntity<>(doctorService.findDoctorById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Doctor> createDoctor(@RequestBody DoctorDTO data){
        return new ResponseEntity<>(doctorService.createDoctor(data), HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Doctor> updateDoctor(@RequestBody DoctorDTO data, @PathVariable Long id){
        return new ResponseEntity<>(doctorService.updateDoctor(data, id), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id){
        doctorService.deleteDoctor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
