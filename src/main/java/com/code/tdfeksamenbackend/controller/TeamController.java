package com.code.tdfeksamenbackend.controller;

import com.code.tdfeksamenbackend.entity.Team;
import com.code.tdfeksamenbackend.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/teams")
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public ResponseEntity<List<Team>> fetchTeams() {
        List<Team> teams = teamService.findAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(teams);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Team> fetchTeamById(@PathVariable Long id) {
        Team team = teamService.findTeamById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(team);
    }

    @PostMapping
    public ResponseEntity<Team> createTeam(@RequestBody Team team) {
        Team createdTeam = teamService.save(team);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(createdTeam);
    }
}
