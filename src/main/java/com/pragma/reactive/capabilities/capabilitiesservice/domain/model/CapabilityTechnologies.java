package com.pragma.reactive.capabilities.capabilitiesservice.domain.model;

public class CapabilityTechnologies {
    private Long capabilityId;
    private Long technologyId;

    public CapabilityTechnologies() {
    }

    public CapabilityTechnologies(Long capabilityId, Long technologyId) {
        this.capabilityId = capabilityId;
        this.technologyId = technologyId;
    }

    public Long getCapabilityId() {
        return capabilityId;
    }

    public void setCapabilityId(Long capabilityId) {
        this.capabilityId = capabilityId;
    }

    public Long getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(Long technologyId) {
        this.technologyId = technologyId;
    }
}
