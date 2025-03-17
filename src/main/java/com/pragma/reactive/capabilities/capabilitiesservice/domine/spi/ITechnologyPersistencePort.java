package com.pragma.reactive.capabilities.capabilitiesservice.domine.spi;

import com.pragma.reactive.capabilities.capabilitiesservice.domine.model.Technology;
import reactor.core.publisher.Mono;

public interface ITechnologyPersistencePort {
    Mono<Technology> getTechnology(Long capabilityId);
}
