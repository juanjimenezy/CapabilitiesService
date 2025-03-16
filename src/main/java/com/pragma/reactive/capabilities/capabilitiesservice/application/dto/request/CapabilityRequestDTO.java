package com.pragma.reactive.capabilities.capabilitiesservice.application.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CapabilityRequestDTO {
    @NotEmpty(message = "name cannot be null")
    private String name;

    @NotEmpty(message = "description cannot be null")
    private String description;

    @NotEmpty(message = "tecnologiesId cannot be null")
    private List<Long> tecnologiesId;
}
