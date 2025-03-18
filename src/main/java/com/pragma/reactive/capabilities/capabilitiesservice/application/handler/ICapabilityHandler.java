package com.pragma.reactive.capabilities.capabilitiesservice.application.handler;

import com.pragma.reactive.capabilities.capabilitiesservice.application.dto.request.CapabilityRequestDTO;
import com.pragma.reactive.capabilities.capabilitiesservice.application.dto.response.CapabilityResponseDTO;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface ICapabilityHandler {
    Mono<CapabilityResponseDTO> createCapability(CapabilityRequestDTO capabilityRequestDTO);
    Flux<CapabilityResponseDTO> getAllCapabilities(int page, int size, boolean asc);
    Mono<CapabilityResponseDTO> getCapability(Long id);
}
