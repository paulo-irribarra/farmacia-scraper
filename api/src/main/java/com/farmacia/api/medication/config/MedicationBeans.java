package com.farmacia.api.medication.config;

import com.farmacia.api.medication.application.IngestMedicationsFromScraperService;
import com.farmacia.api.medication.application.ListMedicationsService;
import com.farmacia.api.medication.domain.port.MedicationCommandPort;
import com.farmacia.api.medication.domain.port.MedicationQueryPort;
import com.farmacia.api.medication.domain.port.MedicationScraperPort;
import com.farmacia.api.medication.domain.usecase.IngestMedicationsFromScraperUseCase;
import com.farmacia.api.medication.domain.usecase.ListMedicationsUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MedicationBeans {

    @Bean
    ListMedicationsUseCase listMedicationsUseCase(MedicationQueryPort queryPort) {
        // <-- Spring inyecta un bean que implemente MedicationQueryPort
        return new ListMedicationsService(queryPort);
    }

    // Si aún no tienes scraper, NO declares aquí el bean de ingesta.
    // (o hazlo @ConditionalOnBean si quieres)
}
