package com.farmacia.api.medication.domain.port;

import com.farmacia.api.medication.domain.model.Medication;

import java.util.List;

public interface MedicationCommandPort {
    void upsertAll(List<Medication> medications); // inserta/actualiza en bloque
}