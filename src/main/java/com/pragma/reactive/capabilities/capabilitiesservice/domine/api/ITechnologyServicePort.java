package com.pragma.reactive.capabilities.capabilitiesservice.domine.api;

import com.pragma.reactive.capabilities.capabilitiesservice.domine.model.Technology;
import reactor.core.publisher.Mono;

public interface ITechnologyServicePort {
    Mono<Technology> getTechnology(Long technologyId);
}
