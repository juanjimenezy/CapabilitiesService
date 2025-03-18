package com.pragma.reactive.capabilities.capabilitiesservice.domain.spi;

import com.pragma.reactive.capabilities.capabilitiesservice.domain.model.CapabilityTechnologies;
import reactor.core.publisher.Flux;

import java.util.List;

public interface ICapabilityTechnologiesPersistencePort {
    Flux<CapabilityTechnologies> saveAll(List<CapabilityTechnologies> capabilityTecnologies);
    Flux<CapabilityTechnologies> findByCapabilityId(Long capabilityId);
}
