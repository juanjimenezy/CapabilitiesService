package com.pragma.reactive.capabilities.capabilitiesservice.infrastructure.input.rest.service;

import com.pragma.reactive.capabilities.capabilitiesservice.domine.model.Technology;
import com.pragma.reactive.capabilities.capabilitiesservice.domine.spi.ITechnologyPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TechnologyService implements ITechnologyPersistencePort {

    private final WebClient webClient;

    @Override
    public Mono<Technology> getTechnology(Long capabilityId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/api/technology/{id}").build(capabilityId))
                .retrieve()
                .bodyToMono(Technology.class) // Convierte la respuesta
                .onErrorResume(e -> {
                    System.err.println("Error al consumir el API: " + e.getMessage());
                    return Mono.empty();
                });
    }
}
