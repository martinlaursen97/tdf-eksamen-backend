package com.code.tdfeksamenbackend.repository;

import com.code.tdfeksamenbackend.entity.Competitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitorRepository extends JpaRepository<Competitor, Long> {
}
