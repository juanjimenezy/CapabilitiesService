package com.pragma.reactive.capabilities.capabilitiesservice.infrastructure.input.rest.controller;

import com.pragma.reactive.capabilities.capabilitiesservice.application.dto.request.CapabilityRequestDTO;
import com.pragma.reactive.capabilities.capabilitiesservice.application.dto.response.CapabilityResponseDTO;
import com.pragma.reactive.capabilities.capabilitiesservice.application.handler.ICapabilityHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/capability")
@RequiredArgsConstructor
@Tag(name = "Capabilities", description = "Gestion Capabilities")
public class CapabilityController {

    private final ICapabilityHandler capabilityHandler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create Capabilities", description = "this endpoint save capabilities")
    public Mono<CapabilityResponseDTO> save(@Valid @RequestBody CapabilityRequestDTO capabilityRequestDTO) {
        return capabilityHandler.createCapability(capabilityRequestDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all capabilities", description = "this endpoint return a list capabilities")
    public Flux<CapabilityResponseDTO> findAll(@RequestParam(defaultValue = "0") int page,
                                               @RequestParam(defaultValue = "10") int size,
                                               @RequestParam(defaultValue = "true") boolean asc) {
        return capabilityHandler.getAllCapabilities(page, size, asc);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get capability by id", description = "this endpoint return capability")
    public Mono<CapabilityResponseDTO> findById(@PathVariable Long id) {
        return capabilityHandler.getCapability(id);
    }

}