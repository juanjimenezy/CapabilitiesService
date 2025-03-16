package com.pragma.reactive.capabilities.capabilitiesservice.infrastructure.output.jpa.mapper;

import com.pragma.reactive.capabilities.capabilitiesservice.domine.model.CapabilityTechnologies;
import com.pragma.reactive.capabilities.capabilitiesservice.infrastructure.output.jpa.entity.CapabilityTechnologiesEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
@Primary
public interface ICapabilityTechnologiesMapper {
    List<CapabilityTechnologiesEntity> toCapabilityTechnologiesEntity(List<CapabilityTechnologies> capabilityTechnologies);
    List<CapabilityTechnologies> toCapabilityTechnologies(List<CapabilityTechnologiesEntity> capabilityTechnologiesEntity);
    CapabilityTechnologies toCapabilityTechnologies(CapabilityTechnologiesEntity capabilityTechnologiesEntity);
}
