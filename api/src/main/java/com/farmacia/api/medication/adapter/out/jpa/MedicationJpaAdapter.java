package com.farmacia.api.medication.adapter.out.jpa;

import com.farmacia.api.medication.domain.model.Medication;
import com.farmacia.api.medication.domain.port.MedicationCommandPort;
import com.farmacia.api.medication.domain.port.MedicationQueryPort;
import com.farmacia.api.shared.PageResult;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component // <-- MUY IMPORTANTE: así Spring registra este bean
public class MedicationJpaAdapter implements MedicationQueryPort {

    private final SpringDataMedicationRepo repo;
    public MedicationJpaAdapter(SpringDataMedicationRepo repo) { this.repo = repo; }

    private Medication toDomain(MedicationJpaEntity e) {
        return new Medication(
                Math.toIntExact(e.getId() == null ? null : e.getId().longValue()),
                e.getName(), e.getStrength(), e.getForm(), e.getUnitCount(), e.getAtcCode()
        );
    }

    @Override
    public PageResult<Medication> list(String q, int page, int size, String sortBy, boolean asc) {
        Sort sort = Sort.by(asc ? Sort.Direction.ASC : Sort.Direction.DESC, sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);

        Page<MedicationJpaEntity> p = (q == null || q.isBlank())
                ? repo.findAll(pageable)
                : repo.findByNameContainingIgnoreCaseOrAtcCodeContainingIgnoreCase(q, q, pageable);

        return new PageResult<>(
                p.getContent().stream().map(this::toDomain).collect(Collectors.toList()),
                p.getTotalElements(), p.getNumber(), p.getSize()
        );
    }
}
