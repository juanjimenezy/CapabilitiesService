package com.pragma.reactive.capabilities.capabilitiesservice.infrastructure.output.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("capability_technology")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CapabilityTechnologiesEntity {
    private Long capabilityId;
    private Long technologyId;
}
