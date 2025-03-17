package com.pragma.reactive.capabilities.capabilitiesservice.domine.spi;

import com.pragma.reactive.capabilities.capabilitiesservice.domine.model.CapabilityTechnologies;
import reactor.core.publisher.Flux;

import java.util.List;

public interface ICapabilityTechnologiesPersistencePort {
    Flux<CapabilityTechnologies> saveAll(List<CapabilityTechnologies> capabilityTecnologies);
    Flux<CapabilityTechnologies> findByCapabilityId(Long capabilityId);
}
