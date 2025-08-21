package com.farmacia.api.medication.adapter.out.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataMedicationRepo extends JpaRepository<MedicationJpaEntity, Integer> {
    Page<MedicationJpaEntity> findByNameContainingIgnoreCaseOrAtcCodeContainingIgnoreCase(
            String name, String atc, Pageable pageable);
}
