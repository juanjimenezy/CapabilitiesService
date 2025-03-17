package com.pragma.reactive.capabilities.capabilitiesservice.application.handler;

import com.pragma.reactive.capabilities.capabilitiesservice.application.dto.request.CapabilityRequestDTO;
import com.pragma.reactive.capabilities.capabilitiesservice.application.dto.response.CapabilityResponseDTO;
import com.pragma.reactive.capabilities.capabilitiesservice.application.mapper.ICapabilityRequestMapper;
import com.pragma.reactive.capabilities.capabilitiesservice.application.mapper.ICapabilityResponseMapper;
import com.pragma.reactive.capabilities.capabilitiesservice.application.mapper.ITechnologyResponseMapper;
import com.pragma.reactive.capabilities.capabilitiesservice.domine.api.ICapabilityServicePort;
import com.pragma.reactive.capabilities.capabilitiesservice.domine.api.ICapabilityTechnologiesServicePort;
import com.pragma.reactive.capabilities.capabilitiesservice.domine.api.ITechnologyServicePort;
import com.pragma.reactive.capabilities.capabilitiesservice.domine.model.CapabilityTechnologies;
import com.pragma.reactive.capabilities.capabilitiesservice.domine.model.Technology;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
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
                            capabilityRequestDTO.getTecnologiesId().stream().map(techId -> new CapabilityTechnologies(capabilitySave.getId(),techId)).toList();
                    return capabilityTechnologiesServicePort.saveAll(capabilityTechnologies).then(Mono.just(capabilitySave));
                })
                .map(capabilityResponseMapper::toResponseDTO);
    }

    @Override
    public Flux<CapabilityResponseDTO> getAllCapabilities(int page, int size, boolean asc) {
        return capabilityServicePort.findAll(page,size,asc)
                .map(capabilityResponseMapper::toResponseDTO)
                .map(capabilityResponseDTO -> {
                    List<CapabilityTechnologies> technologies = capabilityTechnologiesServicePort.fingByCapabilityId(capabilityResponseDTO.getId()).toStream().toList();
                    List<Technology> technology = new ArrayList<Technology>();
                    technologies.stream().map(ct -> technology.add(technologyServicePort.getTechnology(ct.getTechnologyId()).block()));
                    capabilityResponseDTO.setTechnologies(technologyResponseMapper.toTechnologyResponseDTOList(technology));
                    return capabilityResponseDTO;
                });
    }
}
