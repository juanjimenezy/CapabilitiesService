package com.pragma.reactive.capabilities.capabilitiesservice.infrastructure.configuration;

import com.pragma.reactive.capabilities.capabilitiesservice.domine.api.ICapabilityServicePort;
import com.pragma.reactive.capabilities.capabilitiesservice.domine.api.ICapabilityTechnologiesServicePort;
import com.pragma.reactive.capabilities.capabilitiesservice.domine.spi.ICapabilityPersistencePort;
import com.pragma.reactive.capabilities.capabilitiesservice.domine.spi.ICapabilityTechnologiesPersistencePort;
import com.pragma.reactive.capabilities.capabilitiesservice.domine.usecase.CapabilityTechnologiesUseCase;
import com.pragma.reactive.capabilities.capabilitiesservice.domine.usecase.CapabilityUseCase;
import com.pragma.reactive.capabilities.capabilitiesservice.infrastructure.output.jpa.adapter.CapabilityJpaAdapter;
import com.pragma.reactive.capabilities.capabilitiesservice.infrastructure.output.jpa.adapter.CapabilityTechnologiesJpaAdapter;
import com.pragma.reactive.capabilities.capabilitiesservice.infrastructure.output.jpa.mapper.ICapabilityEntityMapper;
import com.pragma.reactive.capabilities.capabilitiesservice.infrastructure.output.jpa.mapper.ICapabilityTechnologiesMapper;
import com.pragma.reactive.capabilities.capabilitiesservice.infrastructure.output.jpa.repository.ICapabilityRepository;
import com.pragma.reactive.capabilities.capabilitiesservice.infrastructure.output.jpa.repository.ICapabilityTechnologiesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final ICapabilityRepository capabilityRepository;
    private final ICapabilityTechnologiesRepository capabilityTecnologiesRepository;
    private final ICapabilityEntityMapper capabilityEntityMapper;
    private final ICapabilityTechnologiesMapper capabilityTechnologiesMapper;

    @Bean
    public ICapabilityPersistencePort capabilityPersistencePort() {
        return new CapabilityJpaAdapter(capabilityRepository, capabilityEntityMapper);
    }

    @Bean
    public ICapabilityServicePort capabilityServicePort() {
        return new CapabilityUseCase(capabilityPersistencePort());
    }

    @Bean
    public ICapabilityTechnologiesPersistencePort capabilityTechnologiesPersistencePort() {
        return new CapabilityTechnologiesJpaAdapter(capabilityTecnologiesRepository,capabilityTechnologiesMapper);
    }

    @Bean
    public ICapabilityTechnologiesServicePort capabilityTechnologiesServicePort() {
        return new CapabilityTechnologiesUseCase(capabilityTechnologiesPersistencePort());
    }

}
