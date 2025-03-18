package com.pragma.reactive.capabilities.capabilitiesservice.application.handler;

import com.pragma.reactive.capabilities.capabilitiesservice.domain.model.CapabilityTechnologies;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public interface ICapabilityTechnologyHandler {
    Flux<CapabilityTechnologies> findByCapabilityId(Long capabilityId);
}
