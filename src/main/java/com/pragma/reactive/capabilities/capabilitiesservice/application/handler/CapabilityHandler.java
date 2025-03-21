package com.pragma.reactive.capabilities.capabilitiesservice.application.handler;

import com.pragma.reactive.capabilities.capabilitiesservice.application.dto.request.CapabilityRequestDTO;
import com.pragma.reactive.capabilities.capabilitiesservice.application.dto.response.CapabilityResponseDTO;
import com.pragma.reactive.capabilities.capabilitiesservice.application.mapper.ICapabilityRequestMapper;
import com.pragma.reactive.capabilities.capabilitiesservice.application.mapper.ICapabilityResponseMapper;
import com.pragma.reactive.capabilities.capabilitiesservice.application.mapper.ITechnologyResponseMapper;
import com.pragma.reactive.capabilities.capabilitiesservice.domain.api.ICapabilityServicePort;
import com.pragma.reactive.capabilities.capabilitiesservice.domain.api.ICapabilityTechnologiesServicePort;
import com.pragma.reactive.capabilities.capabilitiesservice.domain.api.ITechnologyServicePort;
import com.pragma.reactive.capabilities.capabilitiesservice.domain.model.CapabilityTechnologies;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class CapabilityHandler implements ICapabilityHandler {

    private final ICapabilityServicePort capabilityServicePort;
    private final ICapabilityRequestMapper capabilityRequestMapper;
    private final ICapabilityResponseMapper capabilityResponseMapper;
    private final ICapabilityTechnologiesServicePort capabilityTechnologiesServicePort;
    private final ITechnologyServicePort technologyServicePort;
    private final ITechnologyResponseMapper technologyResponseMapper;

    public CapabilityHandler(ICapabilityServicePort capabilityServicePort, ICapabilityRequestMapper capabilityRequestMapper, ICapabilityResponseMapper capabilityResponseMapper, ICapabilityTechnologiesServicePort capabilityTechnologiesServicePort, ITechnologyServicePort technologyServicePort, ITechnologyResponseMapper technologyResponseMapper) {
        this.capabilityServicePort = capabilityServicePort;
        this.capabilityRequestMapper = capabilityRequestMapper;
        this.capabilityResponseMapper = capabilityResponseMapper;
        this.capabilityTechnologiesServicePort = capabilityTechnologiesServicePort;
        this.technologyServicePort = technologyServicePort;
        this.technologyResponseMapper = technologyResponseMapper;
    }

    @Override
    public Mono<CapabilityResponseDTO> createCapability(CapabilityRequestDTO capabilityRequestDTO) {
        return capabilityServicePort.save(capabilityRequestMapper.toCapability(capabilityRequestDTO))
                .flatMap(capabilitySave -> {
                    List<CapabilityTechnologies> capabilityTechnologies =
                            capabilityRequestDTO.getTecnologiesId().stream().map(techId -> new CapabilityTechnologies(capabilitySave.getId(), techId)).toList();
                    return capabilityTechnologiesServicePort.saveAll(capabilityTechnologies).then(Mono.just(capabilitySave));
                })
                .map(capabilityResponseMapper::toResponseDTO);
    }

    @Override
    public Flux<CapabilityResponseDTO> getAllCapabilities(int page, int size, boolean asc) {
        return capabilityServicePort.findAll(page, size, asc)
                .flatMap(capability -> capabilityTechnologiesServicePort.fingByCapabilityId(capability.getId())
                        .flatMap(capTech -> technologyServicePort.getTechnology(capTech.getTechnologyId()))
                        .collectList()
                        .map(techList -> {
                            CapabilityResponseDTO dto = capabilityResponseMapper.toResponseDTO(capability);
                            dto.setTechnologies(technologyResponseMapper.toTechnologyResponseDTOList(techList));
                            return dto;
                        })
                );
    }

    @Override
    public Mono<CapabilityResponseDTO> getCapability(Long id) {
        return capabilityServicePort.findById(id)
                .flatMap(capability -> capabilityTechnologiesServicePort.fingByCapabilityId(capability.getId())
                        .flatMap(capTech -> technologyServicePort.getTechnology(capTech.getTechnologyId()))
                        .collectList()
                        .map(techList -> {
                            CapabilityResponseDTO dto = capabilityResponseMapper.toResponseDTO(capability);
                            dto.setTechnologies(technologyResponseMapper.toTechnologyResponseDTOList(techList));
                            return dto;
                        })
                );
    }
}
