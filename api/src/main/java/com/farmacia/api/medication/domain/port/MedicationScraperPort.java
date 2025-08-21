package com.farmacia.api.medication.domain.port;

import com.farmacia.api.medication.domain.model.Medication;

import java.util.List;

public interface MedicationScraperPort {
    List<Medication> scrape(String query, int maxItems);
}
