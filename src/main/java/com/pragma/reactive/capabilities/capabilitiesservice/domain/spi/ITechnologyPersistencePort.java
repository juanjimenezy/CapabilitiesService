package com.pragma.reactive.capabilities.capabilitiesservice.domain.spi;

import com.pragma.reactive.capabilities.capabilitiesservice.domain.model.Technology;
import reactor.core.publisher.Mono;

public interface ITechnologyPersistencePort {
    Mono<Technology> getTechnology(Long capabilityId);
}
