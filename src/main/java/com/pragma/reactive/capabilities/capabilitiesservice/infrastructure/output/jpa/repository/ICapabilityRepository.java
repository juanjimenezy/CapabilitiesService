package com.pragma.reactive.capabilities.capabilitiesservice.infrastructure.output.jpa.repository;

import com.pragma.reactive.capabilities.capabilitiesservice.infrastructure.output.jpa.entity.CapabilityEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICapabilityRepository extends ReactiveCrudRepository<CapabilityEntity, Long> {
}
