package com.code.tdfeksamenbackend.repository;


import com.code.tdfeksamenbackend.dto.JerseyDTO;
import com.code.tdfeksamenbackend.entity.StageLineItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StageLineItemRepository extends JpaRepository<StageLineItem, Long> {

}
