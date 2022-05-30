package com.code.tdfeksamenbackend.repository;

import com.code.tdfeksamenbackend.controller.StageLineItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StageLineItemRepository extends JpaRepository<StageLineItem, Long> {
}
