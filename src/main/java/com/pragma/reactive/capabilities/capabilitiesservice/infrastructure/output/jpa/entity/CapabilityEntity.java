package com.pragma.reactive.capabilities.capabilitiesservice.infrastructure.output.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "capabilities")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CapabilityEntity {
    @Id
    private Long id;
    private String name;
    private String description;
}
