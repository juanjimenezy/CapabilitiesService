package com.pragma.reactive.capabilities.capabilitiesservice.domine.usecase;

import com.pragma.reactive.capabilities.capabilitiesservice.domine.api.ICapabilityServicePort;
import com.pragma.reactive.capabilities.capabilitiesservice.domine.model.Capability;
import com.pragma.reactive.capabilities.capabilitiesservice.domine.spi.ICapabilityPersistencePort;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CapabilityUseCase implements ICapabilityServicePort {
    private final ICapabilityPersistencePort capabilityPersistencePort;

    public CapabilityUseCase(ICapabilityPersistencePort capabilityPersistencePort) {
        this.capabilityPersistencePort = capabilityPersistencePort;
    }

    @Override
    public Mono<Capability> save(Capability capability) {
        return capabilityPersistencePort.save(capability);
    }

    @Override
    public Flux<Capability> findAll(int page, int size, boolean asc) {
        int offset = page * size;
        if (asc) {
            return capabilityPersistencePort.findAllPageAsc(size, offset);
        }
        return capabilityPersistencePort.findAllPageDesc(size, offset);
    }
}
