package com.code.tdfeksamenbackend.service;

import com.code.tdfeksamenbackend.entity.Stage;
import com.code.tdfeksamenbackend.repository.StageLineItemRepository;
import com.code.tdfeksamenbackend.repository.StageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StageService {

    private final StageRepository stageRepository;

    @Autowired
    public StageService(StageRepository stageRepository) {
        this.stageRepository = stageRepository;
    }

    public List<Stage> findAll() {
        return stageRepository.findAll();
    }

    public Stage save(Stage stage) {
        return stageRepository.save(stage);
    }
}
