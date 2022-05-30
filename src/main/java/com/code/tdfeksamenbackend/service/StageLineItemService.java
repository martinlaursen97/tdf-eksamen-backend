package com.code.tdfeksamenbackend.service;

import com.code.tdfeksamenbackend.controller.StageLineItem;
import com.code.tdfeksamenbackend.repository.StageLineItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StageLineItemService {

    private final StageLineItemRepository stageLineItemRepository;

    @Autowired
    public StageLineItemService(StageLineItemRepository stageLineItemRepository) {
        this.stageLineItemRepository = stageLineItemRepository;
    }

    public List<StageLineItem> findAll() {
        return stageLineItemRepository.findAll();
    }

    public StageLineItem save(StageLineItem stageLineItem) {
        return stageLineItemRepository.save(stageLineItem);
    }
}
