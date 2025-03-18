package com.pragma.reactive.capabilities.capabilitiesservice.infrastructure.input.rest.service;

import com.pragma.reactive.capabilities.capabilitiesservice.domain.model.Technology;
import com.pragma.reactive.capabilities.capabilitiesservice.domain.spi.ITechnologyPersistencePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
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
                    log.error("Error al consumir el servicio >>".concat(e.getMessage()));
                    return Mono.empty();
                });
    }
}
