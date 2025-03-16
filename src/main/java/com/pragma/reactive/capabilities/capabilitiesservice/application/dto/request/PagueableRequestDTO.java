package com.pragma.reactive.capabilities.capabilitiesservice.application.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagueableRequestDTO {
    private int page;
    private int size;
    private boolean asc;
}
