package com.pragma.reactive.capabilities.capabilitiesservice.infrastructure.output.jpa.mapper;

import com.pragma.reactive.capabilities.capabilitiesservice.domain.model.Capability;
import com.pragma.reactive.capabilities.capabilitiesservice.infrastructure.output.jpa.entity.CapabilityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.context.annotation.Primary;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
@Primary
public interface ICapabilityEntityMapper {
    CapabilityEntity toCapabilityEntity(Capability capability);
    Capability toCapabilityObject(CapabilityEntity capabilityEntity);
}
