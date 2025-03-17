package com.pragma.reactive.capabilities.capabilitiesservice.domine.usecase;

import com.pragma.reactive.capabilities.capabilitiesservice.domine.api.ICapabilityTechnologiesServicePort;
import com.pragma.reactive.capabilities.capabilitiesservice.domine.exception.DomainException;
import com.pragma.reactive.capabilities.capabilitiesservice.domine.model.CapabilityTechnologies;
import com.pragma.reactive.capabilities.capabilitiesservice.domine.spi.ICapabilityTechnologiesPersistencePort;
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
