package com.farmacia.api.medication.adapter.out.scraper;

import com.farmacia.api.medication.domain.model.Medication;
import com.farmacia.api.medication.domain.port.MedicationScraperPort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DummyMedicationScraper implements MedicationScraperPort {

    @Override
    public List<Medication> scrape(String query, int maxItems) {
        // Devuelve 2 fakes para probar el flujo end-to-end
        return List.of(
                new Medication(null, "Paracetamol", "500 mg", "tablet", 16, "N02BE01"),
                new Medication(null, "Ibuprofeno", "400 mg", "tablet", 12, "M01AE01")
        );
    }
}
