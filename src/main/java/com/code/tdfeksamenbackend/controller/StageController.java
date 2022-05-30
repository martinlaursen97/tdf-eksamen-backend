package com.code.tdfeksamenbackend.controller;

import com.code.tdfeksamenbackend.entity.Stage;
import com.code.tdfeksamenbackend.service.StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/stages")
public class StageController {

    private final StageService stageService;

    @Autowired
    public StageController(StageService stageService) {
        this.stageService = stageService;
    }

    @GetMapping
    public ResponseEntity<List<Stage>> fetchStages() {
        List<Stage> stages = stageService.findAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(stages);
    }

    @PostMapping
    public ResponseEntity<Stage> createStage(@RequestBody Stage stage) {
        Stage savedStage = stageService.save(stage);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(savedStage);
    }
}
