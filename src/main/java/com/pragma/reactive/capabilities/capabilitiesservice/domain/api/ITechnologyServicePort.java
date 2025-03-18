package com.pragma.reactive.capabilities.capabilitiesservice.domain.api;

import com.pragma.reactive.capabilities.capabilitiesservice.domain.model.Technology;
import reactor.core.publisher.Mono;

public interface ITechnologyServicePort {
    Mono<Technology> getTechnology(Long technologyId);
}
