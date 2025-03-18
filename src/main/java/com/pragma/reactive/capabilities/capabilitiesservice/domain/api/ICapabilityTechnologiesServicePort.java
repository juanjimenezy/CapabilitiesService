package com.pragma.reactive.capabilities.capabilitiesservice.domain.api;

import com.pragma.reactive.capabilities.capabilitiesservice.domain.model.CapabilityTechnologies;
import reactor.core.publisher.Flux;

import java.util.List;

public interface ICapabilityTechnologiesServicePort {
    Flux<CapabilityTechnologies> saveAll(List<CapabilityTechnologies> capabilities);
    Flux<CapabilityTechnologies> fingByCapabilityId(Long id);
}
