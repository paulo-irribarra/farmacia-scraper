package com.farmacia.api.medication.adapter.out.jpa;

import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "medication")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class MedicationJpaEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;            // <-- si tu DB tiene SERIAL/INTEGER
    private String name;
    private String strength;
    private String form;
    private Integer unitCount;
    @Column(name = "atc_code")
    private String atcCode;
}
