package com.pragma.reactive.capabilities.capabilitiesservice.domain.api;

import com.pragma.reactive.capabilities.capabilitiesservice.domain.model.Capability;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICapabilityServicePort {
    Mono<Capability> save(Capability capability);
    Flux<Capability> findAll(int page, int size, boolean asc);
    Mono<Capability> findById(Long id);
}
