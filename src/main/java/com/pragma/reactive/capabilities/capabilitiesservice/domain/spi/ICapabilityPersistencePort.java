package com.pragma.reactive.capabilities.capabilitiesservice.domain.spi;

import com.pragma.reactive.capabilities.capabilitiesservice.domain.model.Capability;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICapabilityPersistencePort {
    Mono<Capability> save(Capability capability);
    Flux<Capability> findAllPageAsc(int limit, int offset);
    Flux<Capability> findAllPageDesc(int limit, int offset);
    Mono<Capability> findById(Long id);
}
