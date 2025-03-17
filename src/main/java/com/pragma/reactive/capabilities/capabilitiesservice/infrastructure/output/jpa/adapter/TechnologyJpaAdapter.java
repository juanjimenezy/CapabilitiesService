package com.pragma.reactive.capabilities.capabilitiesservice.infrastructure.output.jpa.adapter;

import com.pragma.reactive.capabilities.capabilitiesservice.domine.model.Technology;
import com.pragma.reactive.capabilities.capabilitiesservice.domine.spi.ITechnologyPersistencePort;
import com.pragma.reactive.capabilities.capabilitiesservice.infrastructure.input.rest.service.TechnologyService;
import reactor.core.publisher.Mono;

public class TechnologyJpaAdapter implements ITechnologyPersistencePort {

    private final TechnologyService technologyService;

    public TechnologyJpaAdapter(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @Override
    public Mono<Technology> getTechnology(Long capabilityId) {
        return technologyService.getTechnology(capabilityId);
    }
}
