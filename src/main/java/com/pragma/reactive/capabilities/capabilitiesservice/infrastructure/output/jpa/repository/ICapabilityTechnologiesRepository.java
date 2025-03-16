package com.pragma.reactive.capabilities.capabilitiesservice.infrastructure.output.jpa.repository;

import com.pragma.reactive.capabilities.capabilitiesservice.infrastructure.output.jpa.entity.CapabilityTechnologiesEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICapabilityTechnologiesRepository extends ReactiveCrudRepository<CapabilityTechnologiesEntity, Long> {
}
