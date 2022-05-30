package com.code.tdfeksamenbackend.controller;

import com.code.tdfeksamenbackend.service.StageLineItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/stage-line-items")
public class StageLineItem {

    private final StageLineItemService stageLineItemService;

    @Autowired
    public StageLineItem(StageLineItemService stageLineItemService) {
        this.stageLineItemService = stageLineItemService;
    }

    @GetMapping
    public ResponseEntity<List<StageLineItem>> fetchStageLineItems() {
        List<StageLineItem> stageLineItems = stageLineItemService.findAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(stageLineItems);
    }

    @PostMapping
    public ResponseEntity<StageLineItem> createStageLineItem(@RequestBody StageLineItem stageLineItem) {
        StageLineItem savedStageLineItem = stageLineItemService.save(stageLineItem);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(savedStageLineItem);
    }
}
