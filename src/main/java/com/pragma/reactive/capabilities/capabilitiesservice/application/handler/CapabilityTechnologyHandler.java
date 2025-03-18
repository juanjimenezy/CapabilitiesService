package com.pragma.reactive.capabilities.capabilitiesservice.application.handler;

import com.pragma.reactive.capabilities.capabilitiesservice.domain.api.ICapabilityTechnologiesServicePort;
import com.pragma.reactive.capabilities.capabilitiesservice.domain.model.CapabilityTechnologies;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class CapabilityTechnologyHandler implements ICapabilityTechnologyHandler {
    private final ICapabilityTechnologiesServicePort capabilityTechnologiesService;

    public CapabilityTechnologyHandler(ICapabilityTechnologiesServicePort capabilityTechnologiesService) {
        this.capabilityTechnologiesService = capabilityTechnologiesService;
    }

    @Override
    public Flux<CapabilityTechnologies> findByCapabilityId(Long capabilityId) {
        return capabilityTechnologiesService.fingByCapabilityId(capabilityId);
    }
}