package com.pragma.reactive.capabilities.capabilitiesservice.infrastructure.output.jpa.repository;

import com.pragma.reactive.capabilities.capabilitiesservice.infrastructure.output.jpa.entity.CapabilityEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ICapabilityRepository extends ReactiveCrudRepository<CapabilityEntity, Long> {

    @Query("SELECT * FROM capabilities ORDER BY name ASC LIMIT :limit OFFSET :offset")
    Flux<CapabilityEntity> findAllPageAsc(int limit,int offset);

    @Query("SELECT * FROM capabilities ORDER BY name DESC LIMIT :limit OFFSET :offset")
    Flux<CapabilityEntity> findAllPageDesc(@Param("limit") int limit, @Param("offset") int offset);
}
