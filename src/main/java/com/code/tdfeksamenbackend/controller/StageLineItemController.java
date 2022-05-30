package com.code.tdfeksamenbackend.controller;

import com.code.tdfeksamenbackend.constant.Discipline;
import com.code.tdfeksamenbackend.constant.Jersey;
import com.code.tdfeksamenbackend.dto.CountryDTO;
import com.code.tdfeksamenbackend.dto.CompetitorDTO;
import com.code.tdfeksamenbackend.entity.Competitor;
import com.code.tdfeksamenbackend.entity.StageLineItem;
import com.code.tdfeksamenbackend.service.StageLineItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/stage-line-items")
public class StageLineItemController {

    private final StageLineItemService stageLineItemService;

    @Autowired
    public StageLineItemController(StageLineItemService stageLineItemService) {
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

    // DTO
    @GetMapping("/jersey/{jersey}")
    public ResponseEntity<CompetitorDTO> getJerseyOwner(@PathVariable Jersey jersey) {
        CompetitorDTO competitorDTO = stageLineItemService.getJerseyOwner(jersey);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(competitorDTO);
    }

    @GetMapping("/discipline/{discipline}")
    public ResponseEntity<List<CountryDTO>> getCountryScores(@PathVariable Discipline discipline) {
        List<CountryDTO> countryDTOS = stageLineItemService.getCountryDTOByDiscipline(discipline);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(countryDTOS);
    }

    @GetMapping("/best-times")
    public ResponseEntity<List<CompetitorDTO>> getCompetitorsSortedByBestTime() {
        List<CompetitorDTO> competitorDTOS = stageLineItemService.getCompetitorsSortedByBestTime();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(competitorDTOS);
    }
}
