package com.pragma.reactive.capabilities.capabilitiesservice.domine.usecase;

import com.pragma.reactive.capabilities.capabilitiesservice.domine.api.ICapabilityTechnologiesServicePort;
import com.pragma.reactive.capabilities.capabilitiesservice.domine.model.CapabilityTechnologies;
import com.pragma.reactive.capabilities.capabilitiesservice.domine.spi.ICapabilityTechnologiesPersistencePort;
import reactor.core.publisher.Flux;

import java.util.List;

public class CapabilityTechnologiesUseCase implements ICapabilityTechnologiesServicePort {

    private final ICapabilityTechnologiesPersistencePort capabilityTechnologiesPersistencePort;

    public CapabilityTechnologiesUseCase(ICapabilityTechnologiesPersistencePort capabilityTechnologiesPersistencePort) {
        this.capabilityTechnologiesPersistencePort = capabilityTechnologiesPersistencePort;
    }

    @Override
    public Flux<CapabilityTechnologies> saveAll(List<CapabilityTechnologies> capabilityTecnologies) {
        return capabilityTechnologiesPersistencePort.saveAll(capabilityTecnologies);
    }
}
