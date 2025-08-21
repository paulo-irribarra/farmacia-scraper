package com.farmacia.api.medication.domain.usecase;

public interface IngestMedicationsFromScraperUseCase {
    record Params(String query, int maxItems) {}
    int handle(Params params); // retorna cuántos registros se upsertearon
}
