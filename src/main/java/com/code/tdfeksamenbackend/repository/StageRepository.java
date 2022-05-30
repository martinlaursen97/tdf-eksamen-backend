package com.code.tdfeksamenbackend.repository;

import com.code.tdfeksamenbackend.entity.Stage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StageRepository extends JpaRepository<Stage, Long> {
}
