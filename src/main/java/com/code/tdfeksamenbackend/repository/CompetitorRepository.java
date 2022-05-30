package com.code.tdfeksamenbackend.repository;

import com.code.tdfeksamenbackend.entity.Competitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompetitorRepository extends JpaRepository<Competitor, Long> {

    @Query("SELECT c FROM Competitor c WHERE c.team.id = ?1")
    Optional<List<Competitor>> findAllByTeamId(Long id);
}
