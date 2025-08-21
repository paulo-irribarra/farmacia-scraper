package com.farmacia.api.medication.domain.usecase;

import com.farmacia.api.medication.domain.model.Medication;
import com.farmacia.api.shared.PageResult;

public interface ListMedicationsUseCase {
    PageResult<Medication> handle(Params params);

    record Params(String q, int page, int size, String sortBy, boolean asc) {
        public static Params of(String q, Integer page, Integer size, String sortBy, Boolean asc) {
            return new Params(
                    q,
                    page == null ? 0 : page,
                    size == null ? 20 : size,
                    sortBy == null ? "name" : sortBy,
                    asc == null ? true : asc
            );
        }
    }
}
