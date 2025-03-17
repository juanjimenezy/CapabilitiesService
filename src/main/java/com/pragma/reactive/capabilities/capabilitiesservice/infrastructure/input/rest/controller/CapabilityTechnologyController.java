package com.pragma.reactive.capabilities.capabilitiesservice.infrastructure.input.rest.controller;

import com.pragma.reactive.capabilities.capabilitiesservice.application.handler.ICapabilityTechnologyHandler;
import com.pragma.reactive.capabilities.capabilitiesservice.domine.model.CapabilityTechnologies;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/capabilityTechnology")
@RequiredArgsConstructor
public class CapabilityTechnologyController {

    private final ICapabilityTechnologyHandler capabilityTechnologyHandler;

    @GetMapping("/{id}")
    public Flux<CapabilityTechnologies> getCapabilityTechnologies(@PathVariable Long id) {
        return capabilityTechnologyHandler.findByCapabilityId(id);
    }

}
