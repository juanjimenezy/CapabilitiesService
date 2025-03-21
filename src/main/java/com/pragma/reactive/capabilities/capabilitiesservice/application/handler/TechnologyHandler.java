package com.pragma.reactive.capabilities.capabilitiesservice.application.handler;

import com.pragma.reactive.capabilities.capabilitiesservice.domain.api.ITechnologyServicePort;
import com.pragma.reactive.capabilities.capabilitiesservice.domain.model.Technology;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class TechnologyHandler implements ITechnologyHandler {

    private ITechnologyServicePort technologyServicePort;

    @Override
    public Mono<Technology> getTechnologies(Long technologyId) {
        return technologyServicePort.getTechnology(technologyId);
    }
}
