// com/farmacia/medication/adapter/in/web/MedicationController.java
package com.farmacia.api.medication.adapter.in.web;

import com.farmacia.api.shared.PageResult;
import com.farmacia.api.medication.domain.model.Medication;
import com.farmacia.api.medication.domain.usecase.IngestMedicationsFromScraperUseCase;
import com.farmacia.api.medication.domain.usecase.ListMedicationsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/medications")
public class MedicationController {

    private final ListMedicationsUseCase listUseCase;

    public MedicationController(ListMedicationsUseCase listUseCase) {
        this.listUseCase = listUseCase;  // <- ya no será null si el bean existe
    }

    @GetMapping
    public PageResult<Medication> list(
            @RequestParam(required = false) String q,
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size,
            @RequestParam(required = false) String sortBy,
            @RequestParam(required = false) Boolean asc
    ) {
        var params = ListMedicationsUseCase.Params.of(q, page, size, sortBy, asc);
        return listUseCase.handle(params);
    }
}
