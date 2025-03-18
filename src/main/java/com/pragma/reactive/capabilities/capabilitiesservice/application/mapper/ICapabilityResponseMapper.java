package com.pragma.reactive.capabilities.capabilitiesservice.application.mapper;

import com.pragma.reactive.capabilities.capabilitiesservice.application.dto.response.CapabilityResponseDTO;
import com.pragma.reactive.capabilities.capabilitiesservice.domain.model.Capability;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.context.annotation.Primary;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
@Primary
public interface ICapabilityResponseMapper {
    CapabilityResponseDTO toResponseDTO(Capability capability);
}