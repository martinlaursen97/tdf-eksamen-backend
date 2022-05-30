package com.code.tdfeksamenbackend.service;

import com.code.tdfeksamenbackend.entity.Team;
import com.code.tdfeksamenbackend.exception.ApiNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@ActiveProfiles("test")
class TeamServiceTest {

    @Autowired
    private TeamService teamService;

    @Test
    void findTeamById() {
        Team team = teamService.save(new Team());
        Team found = teamService.findTeamById(team.getId());
        Assertions.assertNotNull(found);
    }

    @Test
    void findTeamByIdThrowException() {
        Long id = 0L;
        Assertions.assertThrows(ApiNotFoundException.class, () -> teamService.findTeamById(id));
    }
}