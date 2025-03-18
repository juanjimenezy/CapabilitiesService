package com.pragma.reactive.capabilities.capabilitiesservice.domain.usecase;

import com.pragma.reactive.capabilities.capabilitiesservice.domain.model.Capability;
import com.pragma.reactive.capabilities.capabilitiesservice.domain.spi.ICapabilityPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CapabilityUseCaseTest {

    @Mock
    private ICapabilityPersistencePort capabilityPersistencePort;

    private CapabilityUseCase capabilityUseCase;

    @BeforeEach
    void setUp() {
        capabilityUseCase = new CapabilityUseCase(capabilityPersistencePort);
    }

    @Test
    void testSave() {
        Capability capability = new Capability(1L, "Backend", "Desarrollo backend");
        when(capabilityPersistencePort.save(capability)).thenReturn(Mono.just(capability));
        StepVerifier.create(capabilityUseCase.save(capability))
                .expectNext(capability)
                .verifyComplete();
        verify(capabilityPersistencePort).save(capability);
    }

    @Test
    void testFindAllAsc() {
        Capability capability1 = new Capability(1L, "Backend", "Desarrollo backend");
        Capability capability2 = new Capability(2L, "Frontend", "Desarrollo frontend");

        when(capabilityPersistencePort.findAllPageAsc(2, 0)).thenReturn(Flux.just(capability1, capability2));

        StepVerifier.create(capabilityUseCase.findAll(0, 2, true))
                .expectNext(capability1, capability2)
                .verifyComplete();

        verify(capabilityPersistencePort).findAllPageAsc(2, 0);
    }

    @Test
    void testFindAllDesc() {
        Capability capability1 = new Capability(1L, "Backend", "Desarrollo backend");
        Capability capability2 = new Capability(2L, "Frontend", "Desarrollo frontend");

        when(capabilityPersistencePort.findAllPageDesc(2, 0)).thenReturn(Flux.just(capability2, capability1));

        StepVerifier.create(capabilityUseCase.findAll(0, 2, false))
                .expectNext(capability2, capability1)
                .verifyComplete();

        verify(capabilityPersistencePort).findAllPageDesc(2, 0);
    }

    @Test
    void testFindById() {
        Capability capability = new Capability(1L, "Backend", "Desarrollo backend");

        when(capabilityPersistencePort.findById(1L)).thenReturn(Mono.just(capability));

        StepVerifier.create(capabilityUseCase.findById(1L))
                .expectNext(capability)
                .verifyComplete();

        verify(capabilityPersistencePort).findById(1L);
    }

}
