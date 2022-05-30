package com.code.tdfeksamenbackend.controller;

import com.code.tdfeksamenbackend.entity.Competitor;
import com.code.tdfeksamenbackend.service.CompetitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/competitors")
public class CompetitorController {

    private final CompetitorService competitorService;

    @Autowired
    public CompetitorController(CompetitorService competitorService) {
        this.competitorService = competitorService;
    }

    @GetMapping
    public ResponseEntity<List<Competitor>> fetchCompetitors() {
        List<Competitor> competitors = competitorService.findAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(competitors);
    }

    @PostMapping
    public ResponseEntity<Competitor> createCompetitor(@RequestBody Competitor competitor) {
        Competitor savedCompetitor = competitorService.save(competitor);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(savedCompetitor);
    }

    @PutMapping
    public ResponseEntity<Competitor> updateCompetitor(@RequestBody Competitor competitor) {
        Competitor updatedCompetitor = competitorService.save(competitor);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(updatedCompetitor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Competitor> deleteCompetitor(@PathVariable Long id) {
        competitorService.deleteCompetitorById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }
}
