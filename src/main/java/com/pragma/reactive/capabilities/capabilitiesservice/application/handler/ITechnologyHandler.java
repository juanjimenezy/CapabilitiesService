package com.pragma.reactive.capabilities.capabilitiesservice.application.handler;

import com.pragma.reactive.capabilities.capabilitiesservice.domine.model.Technology;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface ITechnologyHandler {
    Mono<Technology> getTechnologies(Long capabilityId);
}
