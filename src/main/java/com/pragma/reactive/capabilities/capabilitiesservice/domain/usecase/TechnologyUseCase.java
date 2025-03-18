package com.pragma.reactive.capabilities.capabilitiesservice.domain.usecase;

import com.pragma.reactive.capabilities.capabilitiesservice.domain.api.ITechnologyServicePort;
import com.pragma.reactive.capabilities.capabilitiesservice.domain.model.Technology;
import com.pragma.reactive.capabilities.capabilitiesservice.domain.spi.ITechnologyPersistencePort;
import reactor.core.publisher.Mono;

public class TechnologyUseCase implements ITechnologyServicePort {
    private final ITechnologyPersistencePort technologyPersistencePort;

    public TechnologyUseCase(ITechnologyPersistencePort technologyPersistencePort) {
        this.technologyPersistencePort = technologyPersistencePort;
    }

    @Override
    public Mono<Technology> getTechnology(Long technologyId) {
        return technologyPersistencePort.getTechnology(technologyId);
    }
}
