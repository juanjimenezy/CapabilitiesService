package com.pragma.reactive.capabilities.capabilitiesservice.domine.usecase;

import com.pragma.reactive.capabilities.capabilitiesservice.domine.api.ITechnologyServicePort;
import com.pragma.reactive.capabilities.capabilitiesservice.domine.model.Technology;
import com.pragma.reactive.capabilities.capabilitiesservice.domine.spi.ITechnologyPersistencePort;
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
