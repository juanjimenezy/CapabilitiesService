package com.pragma.reactive.capabilities.capabilitiesservice.infrastructure.output.jpa.adapter;

import com.pragma.reactive.capabilities.capabilitiesservice.domain.model.Capability;
import com.pragma.reactive.capabilities.capabilitiesservice.domain.spi.ICapabilityPersistencePort;
import com.pragma.reactive.capabilities.capabilitiesservice.infrastructure.output.jpa.mapper.ICapabilityEntityMapper;
import com.pragma.reactive.capabilities.capabilitiesservice.infrastructure.output.jpa.repository.ICapabilityRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CapabilityJpaAdapter implements ICapabilityPersistencePort {
    private final ICapabilityRepository capabilityRepository;
    private final ICapabilityEntityMapper capabilityEntityMapper;

    @Override
    public Mono<Capability> save(Capability capability) {
        return capabilityRepository.save(capabilityEntityMapper.toCapabilityEntity(capability))
                .map(capabilityEntityMapper::toCapabilityObject);
    }

    @Override
    public Flux<Capability> findAllPageAsc(int limit, int offset) {
        return capabilityRepository.findAllPageAsc(limit,offset)
                .map(capabilityEntityMapper::toCapabilityObject);
    }

    @Override
    public Flux<Capability> findAllPageDesc(int limit, int offset) {
        return capabilityRepository.findAllPageDesc(limit,offset)
                .map(capabilityEntityMapper::toCapabilityObject);
    }

    @Override
    public Mono<Capability> findById(Long id) {
        return capabilityRepository.findById(id)
                .map(capabilityEntityMapper::toCapabilityObject);
    }
}
