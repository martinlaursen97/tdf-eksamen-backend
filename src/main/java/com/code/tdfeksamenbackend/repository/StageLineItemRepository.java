package com.code.tdfeksamenbackend.repository;


import com.code.tdfeksamenbackend.dto.CountryDTO;
import com.code.tdfeksamenbackend.dto.CompetitorDTO;
import com.code.tdfeksamenbackend.entity.StageLineItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StageLineItemRepository extends JpaRepository<StageLineItem, Long> {

    @Query("SELECT new com.code.tdfeksamenbackend.dto.CompetitorDTO(sli.competitor, AVG(sli.time)) " +
            "FROM StageLineItem sli " +
            "GROUP BY sli.competitor.id")
    Optional<List<CompetitorDTO>> getTimes();

    @Query("SELECT new com.code.tdfeksamenbackend.dto.CompetitorDTO(sli.competitor, AVG(sli.sprintPoints)) " +
            "FROM StageLineItem sli " +
            "GROUP BY sli.competitor.id")
    Optional<List<CompetitorDTO>> getSprintPts();

    @Query("SELECT new com.code.tdfeksamenbackend.dto.CompetitorDTO(sli.competitor, AVG(sli.mountainPoints)) " +
            "FROM StageLineItem sli " +
            "GROUP BY sli.competitor.id")
    Optional<List<CompetitorDTO>> getMountainPts();

    @Query("SELECT new com.code.tdfeksamenbackend.dto.CountryDTO(sli.competitor.country, AVG(sli.time)) " +
           "FROM StageLineItem sli " +
           "JOIN Competitor c ON c.id = sli.competitor.id " +
           "GROUP BY c.country.id " +
            "ORDER BY AVG(sli.time) DESC")
    Optional<List<CountryDTO>> getCountryTimes();

    @Query("SELECT new com.code.tdfeksamenbackend.dto.CountryDTO(sli.competitor.country, AVG(sli.sprintPoints)) " +
            "FROM StageLineItem sli " +
            "JOIN Competitor c ON c.id = sli.competitor.id " +
            "GROUP BY c.country.id " +
            "ORDER BY AVG(sli.time) DESC")
    Optional<List<CountryDTO>> getCountrySprintPts();

    @Query("SELECT new com.code.tdfeksamenbackend.dto.CountryDTO(sli.competitor.country, AVG(sli.mountainPoints)) " +
            "FROM StageLineItem sli " +
            "JOIN Competitor c ON c.id = sli.competitor.id " +
            "GROUP BY c.country.id " +
            "ORDER BY AVG(sli.time) DESC")
    Optional<List<CountryDTO>> getCountryMountainPts();

    @Query("SELECT new com.code.tdfeksamenbackend.dto.CompetitorDTO(sli.competitor, AVG(sli.time)) " +
            "FROM StageLineItem sli " +
            "GROUP BY sli.competitor.id " +
            "ORDER BY sli.time DESC")
    Optional<List<CompetitorDTO>> getCompetitorsSortedByBestTime();
}
