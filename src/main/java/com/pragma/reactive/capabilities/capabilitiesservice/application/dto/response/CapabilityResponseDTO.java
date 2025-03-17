package com.pragma.reactive.capabilities.capabilitiesservice.application.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CapabilityResponseDTO {
    private Long id;
    private String name;
    private String description;
    private List<TechnologyResponseDTO> technologies;
}
