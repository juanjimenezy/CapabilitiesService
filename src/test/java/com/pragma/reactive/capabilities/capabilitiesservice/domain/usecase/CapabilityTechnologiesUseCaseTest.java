package com.pragma.reactive.capabilities.capabilitiesservice.domain.usecase;

import com.pragma.reactive.capabilities.capabilitiesservice.domain.exception.DomainException;
import com.pragma.reactive.capabilities.capabilitiesservice.domain.model.CapabilityTechnologies;
import com.pragma.reactive.capabilities.capabilitiesservice.domain.spi.ICapabilityTechnologiesPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

import static org.mockito.Mockito.*;

class CapabilityTechnologiesUseCaseTest {

    @Mock
    private ICapabilityTechnologiesPersistencePort persistencePort;

    private CapabilityTechnologiesUseCase useCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        useCase = new CapabilityTechnologiesUseCase(persistencePort);
    }

    @Test
    void saveAll_WithValidList_ShouldSaveSuccessfully() {
        // Arrange
        List<CapabilityTechnologies> validList = List.of(
                new CapabilityTechnologies(),
                new CapabilityTechnologies(),
                new CapabilityTechnologies()
        );

        when(persistencePort.saveAll(validList)).thenReturn(Flux.fromIterable(validList));

        // Act
        Flux<CapabilityTechnologies> result = useCase.saveAll(validList);

        // Assert
        StepVerifier.create(result)
                .expectNextSequence(validList)
                .verifyComplete();

        verify(persistencePort, times(1)).saveAll(validList);
    }

    @Test
    void saveAll_WithInvalidList_ShouldThrowDomainException() {
        // Arrange
        List<CapabilityTechnologies> invalidList = List.of(); // List vacía

        // Act
        Mono<List<CapabilityTechnologies>> result = useCase.saveAll(invalidList).collectList();

        // Assert
        StepVerifier.create(result)
                .expectError(DomainException.class)
                .verify();

        verifyNoInteractions(persistencePort);
    }

    @Test
    void fingByCapabilityId_ShouldReturnCapabilities() {
        // Arrange
        Long capabilityId = 1L;
        List<CapabilityTechnologies> mockData = List.of(
                new CapabilityTechnologies(),
                new CapabilityTechnologies()
        );

        when(persistencePort.findByCapabilityId(capabilityId)).thenReturn(Flux.fromIterable(mockData));

        // Act
        Flux<CapabilityTechnologies> result = useCase.fingByCapabilityId(capabilityId);

        // Assert
        StepVerifier.create(result)
                .expectNextSequence(mockData)
                .verifyComplete();

        verify(persistencePort, times(1)).findByCapabilityId(capabilityId);
    }
}
