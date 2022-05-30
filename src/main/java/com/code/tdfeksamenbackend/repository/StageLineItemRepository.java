package com.code.tdfeksamenbackend.repository;


import com.code.tdfeksamenbackend.dto.JerseyDTO;
import com.code.tdfeksamenbackend.entity.StageLineItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StageLineItemRepository extends JpaRepository<StageLineItem, Long> {

    @Query("SELECT new com.code.tdfeksamenbackend.dto.JerseyDTO(sli.competitor, AVG(sli.time)) " +
            "FROM StageLineItem sli " +
            "GROUP BY sli.competitor.id")
    Optional<List<JerseyDTO>> getTimes();

    @Query("SELECT new com.code.tdfeksamenbackend.dto.JerseyDTO(sli.competitor, AVG(sli.sprintPoints)) " +
            "FROM StageLineItem sli " +
            "GROUP BY sli.competitor.id")
    Optional<List<JerseyDTO>> getSprintPts();

    @Query("SELECT new com.code.tdfeksamenbackend.dto.JerseyDTO(sli.competitor, AVG(sli.mountainPoints)) " +
            "FROM StageLineItem sli " +
            "GROUP BY sli.competitor.id")
    Optional<List<JerseyDTO>> getMountainPts();
}
