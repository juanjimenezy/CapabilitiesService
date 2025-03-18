package com.pragma.reactive.capabilities.capabilitiesservice.application.mapper;

import com.pragma.reactive.capabilities.capabilitiesservice.application.dto.response.TechnologyResponseDTO;
import com.pragma.reactive.capabilities.capabilitiesservice.domain.model.Technology;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
@Primary
public interface ITechnologyResponseMapper {
    TechnologyResponseDTO toTechnologyResponseDTO(Technology technology);
    List<TechnologyResponseDTO> toTechnologyResponseDTOList(List<Technology> technologies);
}
