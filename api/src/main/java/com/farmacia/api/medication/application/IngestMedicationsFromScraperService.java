package com.farmacia.api.medication.application;

import com.farmacia.api.medication.domain.port.MedicationCommandPort;
import com.farmacia.api.medication.domain.port.MedicationScraperPort;
import com.farmacia.api.medication.domain.usecase.IngestMedicationsFromScraperUseCase;

public class IngestMedicationsFromScraperService implements IngestMedicationsFromScraperUseCase {
    private final MedicationScraperPort scraperPort;
    private final MedicationCommandPort commandPort;

    public IngestMedicationsFromScraperService(MedicationScraperPort scraperPort,
                                               MedicationCommandPort commandPort) {
        this.scraperPort = scraperPort;
        this.commandPort = commandPort;
    }

    @Override
    public int handle(Params params) {
        var meds = scraperPort.scrape(params.query(), params.maxItems());
        commandPort.upsertAll(meds);
        return meds.size();
    }
}
