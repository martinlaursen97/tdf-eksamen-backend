package com.code.tdfeksamenbackend.service;

import com.code.tdfeksamenbackend.entity.Competitor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class CompetitorServiceTest {

    private final CompetitorService competitorService;
    private final CountryService countryService;
    private final TeamService teamService;

    @Autowired
    public CompetitorServiceTest(
            CompetitorService competitorService,
            CountryService countryService,
            TeamService teamService) {
        this.competitorService = competitorService;
        this.countryService = countryService;
        this.teamService = teamService;
    }

    //@BeforeTestClass
    //public void setup() {
    //
    //}

    @Test
    void findAllByTeamId() {
        List<Competitor> found = competitorService.findAllByTeamId(1L);
        Assertions.assertEquals(1, found.size());
    }
}