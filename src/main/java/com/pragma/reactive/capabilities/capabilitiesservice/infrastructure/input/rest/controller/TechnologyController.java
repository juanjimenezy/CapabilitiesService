package com.pragma.reactive.capabilities.capabilitiesservice.infrastructure.input.rest.controller;

import com.pragma.reactive.capabilities.capabilitiesservice.domine.model.Technology;
import com.pragma.reactive.capabilities.capabilitiesservice.infrastructure.input.rest.service.TechnologyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/technology")
@RequiredArgsConstructor
public class TechnologyController {
    private final TechnologyService technologyService;

    @GetMapping("/{id}")
    public Mono<Technology> getTechnologies(@PathVariable Long id) {
        return technologyService.getTechnology(id);
    }
}
