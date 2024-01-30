package org.hanniel.hospital.services;

import org.hanniel.hospital.domain.Patient;
import org.hanniel.hospital.domain.UrgencyQueue;
import org.hanniel.hospital.dtos.RequestPatient;
import org.hanniel.hospital.dtos.UrgencyQueueDTO;
import org.hanniel.hospital.exceptions.BadRequestException;
import org.hanniel.hospital.repositories.UrgencyQueueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UrgencyQueueService {

    @Autowired
    UrgencyQueueRepository urgencyQueueRepository;

    @Autowired
    PatientService patientService;

    public List<UrgencyQueue> getAllUrgencyQueue() {
        return urgencyQueueRepository.findAll();
    }

    public UrgencyQueue findUrgencyQueueById(Long id) {
        return urgencyQueueRepository.findById(id).orElseThrow(() ->
                new BadRequestException("Urgency Queue", id));
    }

    public UrgencyQueue createUrgencyQueue(UrgencyQueueDTO data) {
       UrgencyQueue urgencyQueue = new UrgencyQueue(data);
        return urgencyQueueRepository.save(urgencyQueue);
    }

    public UrgencyQueue updateUrgencyQueue(UrgencyQueueDTO data, Long id){
        UrgencyQueue urgencyQueue = findUrgencyQueueById(id);
        urgencyQueue.setName(data.name());
        urgencyQueue.setPatients(data.patients());
        return urgencyQueueRepository.save(urgencyQueue);
    }

    public void deleteUrgencyQueue(Long id){
        urgencyQueueRepository.deleteById(id);
    }
}
