package com.pragma.reactive.capabilities.capabilitiesservice.application.handler;

import com.pragma.reactive.capabilities.capabilitiesservice.domine.model.Technology;
import reactor.core.publisher.Mono;

public interface ITechnologyHandler {
    Mono<Technology> getTechnologies(Long capabilityId);
}
