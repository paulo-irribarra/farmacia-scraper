package com.farmacia.api.medication.domain.port;

import com.farmacia.api.medication.domain.model.Medication;
import com.farmacia.api.shared.PageResult;

public interface MedicationQueryPort {
    PageResult<Medication> list(String q, int page, int size, String sortBy, boolean asc);
}
