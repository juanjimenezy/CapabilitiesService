package com.pragma.reactive.capabilities.capabilitiesservice.infrastructure.input.rest.controller;

import com.pragma.reactive.capabilities.capabilitiesservice.application.dto.request.CapabilityRequestDTO;
import com.pragma.reactive.capabilities.capabilitiesservice.application.dto.response.CapabilityResponseDTO;
import com.pragma.reactive.capabilities.capabilitiesservice.application.handler.ICapabilityHandler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/capability")
@RequiredArgsConstructor
public class CapabilityController {

    private final ICapabilityHandler capabilityHandler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<CapabilityResponseDTO> save(@Valid @RequestBody CapabilityRequestDTO capabilityRequestDTO) {
        return capabilityHandler.createCapability(capabilityRequestDTO);
    }
}
