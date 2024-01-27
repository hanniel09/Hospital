package org.hanniel.hospital.controllers;

import org.hanniel.hospital.domain.UrgencyQueue;
import org.hanniel.hospital.dtos.UrgencyQueueDTO;
import org.hanniel.hospital.services.UrgencyQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/urgency")
public class UrgencyQueueController {

    @Autowired
    UrgencyQueueService urgencyQueueService;

    @GetMapping()
    public ResponseEntity<List<UrgencyQueue>> getAllUrgencyQueue(){
        return new ResponseEntity<>(urgencyQueueService.getAllUrgencyQueue(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UrgencyQueue> getUrgencyQueueById(@PathVariable Long id){
        return new ResponseEntity<>(urgencyQueueService.findUrgencyQueueById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<UrgencyQueue> createUrgencyQueue(@RequestBody UrgencyQueueDTO data){
        return new ResponseEntity<>(urgencyQueueService.createUrgencyQueue(data), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<UrgencyQueue> updateUrgencyQueue(@RequestBody UrgencyQueueDTO data,@PathVariable Long id){
        return new ResponseEntity<>(urgencyQueueService.updateUrgencyQueue(data, id), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteUrgencyQueue(@PathVariable Long id){
        urgencyQueueService.deleteUrgencyQueue(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
