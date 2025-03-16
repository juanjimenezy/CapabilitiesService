package com.pragma.reactive.capabilities.capabilitiesservice.domine.spi;

import com.pragma.reactive.capabilities.capabilitiesservice.domine.model.Capability;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICapabilityPersistencePort {
    Mono<Capability> save(Capability capability);
    Flux<Capability> findAllPageAsc(int limit, int offset);
    Flux<Capability> findAllPageDesc(int limit, int offset);
}
