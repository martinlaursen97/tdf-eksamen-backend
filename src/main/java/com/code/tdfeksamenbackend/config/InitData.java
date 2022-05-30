package com.code.tdfeksamenbackend.config;

import com.code.tdfeksamenbackend.entity.*;
import com.code.tdfeksamenbackend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class InitData implements CommandLineRunner {

    private final CompetitorService competitorService;
    private final CountryService countryService;
    private final TeamService teamService;
    private final StageService stageService;
    private final StageLineItemService stageLineItemService;

    @Autowired
    public InitData(
            CompetitorService competitorService,
            CountryService countryService,
            TeamService teamService,
            StageService stageService,
            StageLineItemService stageLineItemService
    ) {
        this.competitorService = competitorService;
        this.countryService = countryService;
        this.teamService = teamService;
        this.stageService = stageService;
        this.stageLineItemService = stageLineItemService;
    }

    @Override
    public void run(String... args) {
        // Stages
        Stage stage1 = new Stage();
        stage1.setDate(LocalDateTime.now());

        Stage stage2 = new Stage();
        stage2.setDate(LocalDateTime.now());

        Stage stage3 = new Stage();
        stage3.setDate(LocalDateTime.now());

        Stage savedStage1 = stageService.save(stage1);
        Stage savedStage2 = stageService.save(stage2);
        Stage savedStage3 = stageService.save(stage3);


        // Countries
        Country country1 = new Country();
        country1.setName("Denmark");

        Country country2 = new Country();
        country2.setName("France");

        Country savedCountry1 = countryService.save(country1);
        Country savedCountry2 = countryService.save(country2);

        // Teams
        Team team1 = new Team();
        team1.setName("T1");

        Team team2 = new Team();
        team2.setName("T2");

        Team savedTeam1 = teamService.save(team1);
        Team savedTeam2 = teamService.save(team2);

        // Competitors
        Competitor competitor1 = new Competitor();
        competitor1.setFirstName("Martin");
        competitor1.setLastName("Laursen");
        competitor1.setAge(20);
        competitor1.setCountry(savedCountry1);
        competitor1.setTeam(savedTeam1);

        Competitor competitor2 = new Competitor();
        competitor2.setFirstName("Kenned");
        competitor2.setLastName("Larsen");
        competitor2.setAge(30);
        competitor2.setCountry(savedCountry2);
        competitor2.setTeam(savedTeam2);

        Competitor savedCompetitor1 = competitorService.save(competitor1);
        Competitor savedCompetitor2 = competitorService.save(competitor2);

        // StageLineItems
        StageLineItem stageLineItem1 = new StageLineItem();
        stageLineItem1.setStage(savedStage1);
        stageLineItem1.setCompetitor(savedCompetitor1);
        stageLineItem1.setTime(120.5);
        stageLineItem1.setSprintPoints(10.);
        stageLineItem1.setMountainPoints(20.);

        StageLineItem stageLineItem2 = new StageLineItem();
        stageLineItem2.setStage(savedStage1);
        stageLineItem2.setCompetitor(savedCompetitor2);
        stageLineItem2.setTime(110.5);
        stageLineItem2.setSprintPoints(15.);
        stageLineItem2.setMountainPoints(21.);

        StageLineItem stageLineItem3 = new StageLineItem();
        stageLineItem3.setStage(savedStage2);
        stageLineItem3.setCompetitor(savedCompetitor1);
        stageLineItem3.setTime(40.);
        stageLineItem3.setSprintPoints(15.);
        stageLineItem3.setMountainPoints(21.);

        StageLineItem stageLineItem4 = new StageLineItem();
        stageLineItem4.setStage(savedStage2);
        stageLineItem4.setCompetitor(savedCompetitor1);
        stageLineItem4.setTime(43.);
        stageLineItem4.setSprintPoints(12.);
        stageLineItem4.setMountainPoints(5.);



        stageLineItemService.save(stageLineItem1);
        stageLineItemService.save(stageLineItem2);
        stageLineItemService.save(stageLineItem3);
        stageLineItemService.save(stageLineItem4);



    }
}
