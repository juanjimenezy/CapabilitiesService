package com.pragma.reactive.capabilities.capabilitiesservice.application.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CapabilityRequestDTO {
    private Long id;
    private String name;
    private String description;
    private List<Long> tecnologiesId;
}
