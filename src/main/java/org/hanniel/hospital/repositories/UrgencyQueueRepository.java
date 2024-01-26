package org.hanniel.hospital.repositories;

import org.hanniel.hospital.domain.UrgencyQueue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrgencyQueueRepository extends JpaRepository<UrgencyQueue, Long> {
}
