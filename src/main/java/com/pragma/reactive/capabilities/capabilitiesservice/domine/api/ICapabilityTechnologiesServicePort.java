package com.pragma.reactive.capabilities.capabilitiesservice.domine.api;

import com.pragma.reactive.capabilities.capabilitiesservice.domine.model.CapabilityTechnologies;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public interface ICapabilityTechnologiesServicePort {
    Flux<CapabilityTechnologies> saveAll(List<CapabilityTechnologies> capabilities);
}
