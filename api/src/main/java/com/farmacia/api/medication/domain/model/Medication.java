package com.farmacia.api.medication.domain.model;

public record Medication(
        Integer id,
        String name,
        String strength,
        String form,
        Integer unitCount,
        String atcCode
) {}
