package com.farmacia.api.medication.application;

import com.farmacia.api.medication.domain.model.Medication;
import com.farmacia.api.medication.domain.port.MedicationQueryPort;
import com.farmacia.api.medication.domain.usecase.ListMedicationsUseCase;
import com.farmacia.api.shared.PageResult;

public class ListMedicationsService implements ListMedicationsUseCase {
    private final MedicationQueryPort queryPort;
    public ListMedicationsService(MedicationQueryPort queryPort) {
        this.queryPort = queryPort;
    }
    @Override public PageResult<Medication> handle(Params p) {
        return queryPort.list(p.q(), p.page(), p.size(), p.sortBy(), p.asc());
    }
}
