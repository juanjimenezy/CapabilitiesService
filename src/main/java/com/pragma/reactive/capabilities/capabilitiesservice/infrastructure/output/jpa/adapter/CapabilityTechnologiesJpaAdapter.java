package com.pragma.reactive.capabilities.capabilitiesservice.infrastructure.output.jpa.adapter;

import com.pragma.reactive.capabilities.capabilitiesservice.domine.model.CapabilityTechnologies;
import com.pragma.reactive.capabilities.capabilitiesservice.domine.spi.ICapabilityTechnologiesPersistencePort;
import com.pragma.reactive.capabilities.capabilitiesservice.infrastructure.output.jpa.mapper.ICapabilityTechnologiesMapper;
import com.pragma.reactive.capabilities.capabilitiesservice.infrastructure.output.jpa.repository.ICapabilityTechnologiesRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

import java.util.List;

@RequiredArgsConstructor
public class CapabilityTechnologiesJpaAdapter implements ICapabilityTechnologiesPersistencePort {

    private final ICapabilityTechnologiesRepository repository;
    private final ICapabilityTechnologiesMapper mapper;

    @Override
    public Flux<CapabilityTechnologies> saveAll(List<CapabilityTechnologies> capabilityTecnologies) {
        return repository.saveAll(mapper.toCapabilityTechnologiesEntity(capabilityTecnologies))
                .map(mapper::toCapabilityTechnologies);
    }
}
