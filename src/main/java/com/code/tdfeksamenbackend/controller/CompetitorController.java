package com.code.tdfeksamenbackend.controller;

import com.code.tdfeksamenbackend.entity.Competitor;
import com.code.tdfeksamenbackend.service.CompetitorService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Page<Competitor>> fetchCompetitors(
            @RequestParam Optional<Integer> page,
            @RequestParam Optional<String> sortBy,
            @RequestParam Optional<Sort.Direction> sortDirection
    ) {

        Page<Competitor> competitors = competitorService.findAll(
                PageRequest.of(
                        page.orElse(0),
                        3,
                        sortDirection.orElse(Sort.Direction.ASC), sortBy.orElse("id")
                )
        );

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(competitors);
    }

    @GetMapping("/team/{id}")
    public ResponseEntity<List<Competitor>> fetchCompetitorsByTeamId(@PathVariable Long id) {
        List<Competitor> competitors = competitorService.findAllByTeamId(id);
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

    @PutMapping("/{id}")
    public ResponseEntity<Competitor> updateCompetitor(
            @RequestBody Competitor competitor,
            @PathVariable Long id) {

        Competitor competitorToUpdate = competitorService.findCompetitorById(id);

        competitorToUpdate.setCountry(competitor.getCountry());
        competitorToUpdate.setTeam(competitor.getTeam());
        competitorToUpdate.setFirstName(competitor.getFirstName());
        competitorToUpdate.setLastName(competitor.getLastName());
        competitorToUpdate.setAge(competitor.getAge());

        Competitor updatedCompetitor = competitorService.update(competitorToUpdate);

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
