package com.pragma.reactive.capabilities.capabilitiesservice.domain.usecase;

import com.pragma.reactive.capabilities.capabilitiesservice.domain.api.ICapabilityTechnologiesServicePort;
import com.pragma.reactive.capabilities.capabilitiesservice.domain.exception.DomainException;
import com.pragma.reactive.capabilities.capabilitiesservice.domain.model.CapabilityTechnologies;
import com.pragma.reactive.capabilities.capabilitiesservice.domain.spi.ICapabilityTechnologiesPersistencePort;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class CapabilityTechnologiesUseCase implements ICapabilityTechnologiesServicePort {

    private final ICapabilityTechnologiesPersistencePort capabilityTechnologiesPersistencePort;

    public CapabilityTechnologiesUseCase(ICapabilityTechnologiesPersistencePort capabilityTechnologiesPersistencePort) {
        this.capabilityTechnologiesPersistencePort = capabilityTechnologiesPersistencePort;
    }

    @Override
    public Flux<CapabilityTechnologies> saveAll(List<CapabilityTechnologies> capabilityTecnologies) {
        return Mono.just(capabilityTecnologies)
                .filter(list -> list.size() >= 3 && list.size() <= 20)
                .switchIfEmpty(Mono.error(new DomainException("The list must contain between 3 and 20 records.")))
                .flatMapMany(capabilityTechnologiesPersistencePort::saveAll);
    }

    @Override
    public Flux<CapabilityTechnologies> fingByCapabilityId(Long id) {
        return capabilityTechnologiesPersistencePort.findByCapabilityId(id);
    }
}
