package com.pragma.reactive.capabilities.capabilitiesservice.domain.usecase;

import com.pragma.reactive.capabilities.capabilitiesservice.domain.model.Technology;
import com.pragma.reactive.capabilities.capabilitiesservice.domain.spi.ITechnologyPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.*;

class TechnologyUseCaseTest {

    @Mock
    private ITechnologyPersistencePort persistencePort;

    private TechnologyUseCase useCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        useCase = new TechnologyUseCase(persistencePort);
    }

    @Test
    void getTechnology_ShouldReturnTechnology_WhenIdIsValid() {
        // Arrange
        Long technologyId = 1L;
        Technology mockTechnology = new Technology();
        mockTechnology.setId(technologyId);
        mockTechnology.setName("Reactive Programming");

        when(persistencePort.getTechnology(technologyId)).thenReturn(Mono.just(mockTechnology));

        // Act
        Mono<Technology> result = useCase.getTechnology(technologyId);

        // Assert
        StepVerifier.create(result)
                .expectNextMatches(technology ->
                        technology.getId().equals(technologyId) &&
                                technology.getName().equals("Reactive Programming")
                )
                .verifyComplete();

        verify(persistencePort, times(1)).getTechnology(technologyId);
    }

    @Test
    void getTechnology_ShouldReturnEmptyMono_WhenIdIsInvalid() {
        // Arrange
        Long invalidTechnologyId = 999L;

        when(persistencePort.getTechnology(invalidTechnologyId)).thenReturn(Mono.empty());

        // Act
        Mono<Technology> result = useCase.getTechnology(invalidTechnologyId);

        // Assert
        StepVerifier.create(result)
                .expectNextCount(0)
                .verifyComplete();

        verify(persistencePort, times(1)).getTechnology(invalidTechnologyId);
    }
}
