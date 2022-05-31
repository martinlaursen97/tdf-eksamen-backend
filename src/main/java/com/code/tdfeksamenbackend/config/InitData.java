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

        Country country3 = new Country();
        country3.setName("England");

        Country country4 = new Country();
        country4.setName("Sweden");

        Country country5 = new Country();
        country5.setName("Germany");

        Country country6 = new Country();
        country6.setName("Spain");

        Country country7 = new Country();
        country7.setName("Ungarn");

        Country savedCountry1 = countryService.save(country1);
        Country savedCountry2 = countryService.save(country2);
        Country savedCountry3 = countryService.save(country3);
        Country savedCountry4 = countryService.save(country4);
        Country savedCountry5 = countryService.save(country5);
        Country savedCountry6 = countryService.save(country6);
        Country savedCountry7 = countryService.save(country7);


        // Teams
        Team team1 = new Team();
        team1.setName("Quick-Step Alpha Vinyl");

        Team team2 = new Team();
        team2.setName("UAE Team Emirates");

        Team team3 = new Team();
        team3.setName("Astana Qazaqstan Team");

        Team team4 = new Team();
        team4.setName("Bahrain - Victorious");

        Team team5 = new Team();
        team5.setName("Trek - Segafredo");

        Team savedTeam1 = teamService.save(team1);
        Team savedTeam2 = teamService.save(team2);
        Team savedTeam3 = teamService.save(team3);
        Team savedTeam4 = teamService.save(team4);
        Team savedTeam5 = teamService.save(team5);

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

        Competitor competitor3 = new Competitor();
        competitor3.setFirstName("Søren");
        competitor3.setLastName("Steenum");
        competitor3.setAge(21);
        competitor3.setCountry(savedCountry5);
        competitor3.setTeam(savedTeam2);

        Competitor competitor4 = new Competitor();
        competitor4.setFirstName("Martin");
        competitor4.setLastName("Larsen");
        competitor4.setAge(23);
        competitor4.setCountry(savedCountry3);
        competitor4.setTeam(savedTeam1);

        Competitor competitor5 = new Competitor();
        competitor5.setFirstName("Peter");
        competitor5.setLastName("Sørensen");
        competitor5.setAge(4);
        competitor5.setCountry(savedCountry1);
        competitor5.setTeam(savedTeam2);

        Competitor competitor6 = new Competitor();
        competitor6.setFirstName("Kenneth");
        competitor6.setLastName("Steenum");
        competitor6.setAge(19);
        competitor6.setCountry(savedCountry3);
        competitor6.setTeam(savedTeam1);

        Competitor competitor7 = new Competitor();
        competitor7.setFirstName("Martin");
        competitor7.setLastName("Larsen");
        competitor7.setAge(20);
        competitor7.setCountry(savedCountry4);
        competitor7.setTeam(savedTeam5);

        Competitor competitor8 = new Competitor();
        competitor8.setFirstName("Søren");
        competitor8.setLastName("Sørensen");
        competitor8.setAge(26);
        competitor8.setCountry(savedCountry5);
        competitor8.setTeam(savedTeam3);

        Competitor competitor9 = new Competitor();
        competitor9.setFirstName("Martin");
        competitor9.setLastName("Sørensen");
        competitor9.setAge(2);
        competitor9.setCountry(savedCountry4);
        competitor9.setTeam(savedTeam3);

        Competitor competitor10 = new Competitor();
        competitor10.setFirstName("Søren");
        competitor10.setLastName("Steenum");
        competitor10.setAge(21);
        competitor10.setCountry(savedCountry7);
        competitor10.setTeam(savedTeam5);

        Competitor competitor11 = new Competitor();
        competitor11.setFirstName("Mikael");
        competitor11.setLastName("Larsen");
        competitor11.setAge(13);
        competitor11.setCountry(savedCountry2);
        competitor11.setTeam(savedTeam2);

        Competitor competitor12 = new Competitor();
        competitor12.setFirstName("Martin");
        competitor12.setLastName("Larsen");
        competitor12.setAge(4);
        competitor12.setCountry(savedCountry4);
        competitor12.setTeam(savedTeam5);

        Competitor competitor13 = new Competitor();
        competitor13.setFirstName("Mikael");
        competitor13.setLastName("Larsen");
        competitor13.setAge(10);
        competitor13.setCountry(savedCountry5);
        competitor13.setTeam(savedTeam2);

        Competitor competitor14 = new Competitor();
        competitor14.setFirstName("Kenneth");
        competitor14.setLastName("Laursen");
        competitor14.setAge(19);
        competitor14.setCountry(savedCountry7);
        competitor14.setTeam(savedTeam3);

        Competitor competitor15 = new Competitor();
        competitor15.setFirstName("Søren");
        competitor15.setLastName("Steenum");
        competitor15.setAge(35);
        competitor15.setCountry(savedCountry4);
        competitor15.setTeam(savedTeam2);

        Competitor competitor16 = new Competitor();
        competitor16.setFirstName("Søren");
        competitor16.setLastName("Sørensen");
        competitor16.setAge(8);
        competitor16.setCountry(savedCountry7);
        competitor16.setTeam(savedTeam2);

        Competitor competitor17 = new Competitor();
        competitor17.setFirstName("Søren");
        competitor17.setLastName("Steenum");
        competitor17.setAge(1);
        competitor17.setCountry(savedCountry4);
        competitor17.setTeam(savedTeam1);

        Competitor competitor18 = new Competitor();
        competitor18.setFirstName("Martin");
        competitor18.setLastName("Petersen");
        competitor18.setAge(35);
        competitor18.setCountry(savedCountry4);
        competitor18.setTeam(savedTeam4);

        Competitor competitor19 = new Competitor();
        competitor19.setFirstName("Mikael");
        competitor19.setLastName("Laursen");
        competitor19.setAge(33);
        competitor19.setCountry(savedCountry4);
        competitor19.setTeam(savedTeam4);

        Competitor competitor20 = new Competitor();
        competitor20.setFirstName("Martin");
        competitor20.setLastName("Larsen");
        competitor20.setAge(39);
        competitor20.setCountry(savedCountry3);
        competitor20.setTeam(savedTeam5);

        Competitor competitor21 = new Competitor();
        competitor21.setFirstName("Søren");
        competitor21.setLastName("Petersen");
        competitor21.setAge(37);
        competitor21.setCountry(savedCountry6);
        competitor21.setTeam(savedTeam1);

        Competitor competitor22 = new Competitor();
        competitor22.setFirstName("Martin");
        competitor22.setLastName("Larsen");
        competitor22.setAge(38);
        competitor22.setCountry(savedCountry4);
        competitor22.setTeam(savedTeam4);

        Competitor competitor23 = new Competitor();
        competitor23.setFirstName("Søren");
        competitor23.setLastName("Sørensen");
        competitor23.setAge(30);
        competitor23.setCountry(savedCountry2);
        competitor23.setTeam(savedTeam3);

        Competitor competitor24 = new Competitor();
        competitor24.setFirstName("Martin");
        competitor24.setLastName("Larsen");
        competitor24.setAge(12);
        competitor24.setCountry(savedCountry5);
        competitor24.setTeam(savedTeam5);

        Competitor competitor25 = new Competitor();
        competitor25.setFirstName("Peter");
        competitor25.setLastName("Laursen");
        competitor25.setAge(37);
        competitor25.setCountry(savedCountry5);
        competitor25.setTeam(savedTeam2);

        Competitor competitor26 = new Competitor();
        competitor26.setFirstName("Mikael");
        competitor26.setLastName("Petersen");
        competitor26.setAge(10);
        competitor26.setCountry(savedCountry4);
        competitor26.setTeam(savedTeam2);

        Competitor competitor27 = new Competitor();
        competitor27.setFirstName("Martin");
        competitor27.setLastName("Sørensen");
        competitor27.setAge(5);
        competitor27.setCountry(savedCountry4);
        competitor27.setTeam(savedTeam1);

        Competitor competitor28 = new Competitor();
        competitor28.setFirstName("Søren");
        competitor28.setLastName("Petersen");
        competitor28.setAge(6);
        competitor28.setCountry(savedCountry6);
        competitor28.setTeam(savedTeam5);

        Competitor competitor29 = new Competitor();
        competitor29.setFirstName("Kenneth");
        competitor29.setLastName("Laursen");
        competitor29.setAge(39);
        competitor29.setCountry(savedCountry1);
        competitor29.setTeam(savedTeam3);

        Competitor savedCompetitor1 = competitorService.save(competitor1);
        Competitor savedCompetitor2 = competitorService.save(competitor2);
        Competitor savedCompetitor3 = competitorService.save(competitor3);
        Competitor savedCompetitor4 = competitorService.save(competitor4);
        Competitor savedCompetitor5 = competitorService.save(competitor5);
        Competitor savedCompetitor6 = competitorService.save(competitor6);
        Competitor savedCompetitor7 = competitorService.save(competitor7);
        Competitor savedCompetitor8 = competitorService.save(competitor8);
        Competitor savedCompetitor9 = competitorService.save(competitor9);
        Competitor savedCompetitor10 = competitorService.save(competitor10);
        Competitor savedCompetitor11 = competitorService.save(competitor11);
        Competitor savedCompetitor12 = competitorService.save(competitor12);
        Competitor savedCompetitor13 = competitorService.save(competitor13);
        Competitor savedCompetitor14 = competitorService.save(competitor14);
        Competitor savedCompetitor15 = competitorService.save(competitor15);
        Competitor savedCompetitor16 = competitorService.save(competitor16);
        Competitor savedCompetitor17 = competitorService.save(competitor17);
        Competitor savedCompetitor18 = competitorService.save(competitor18);
        Competitor savedCompetitor19 = competitorService.save(competitor19);
        Competitor savedCompetitor20 = competitorService.save(competitor20);
        Competitor savedCompetitor21 = competitorService.save(competitor21);
        Competitor savedCompetitor22 = competitorService.save(competitor22);
        Competitor savedCompetitor23 = competitorService.save(competitor23);
        Competitor savedCompetitor24 = competitorService.save(competitor24);
        Competitor savedCompetitor25 = competitorService.save(competitor25);
        Competitor savedCompetitor26 = competitorService.save(competitor26);
        Competitor savedCompetitor27 = competitorService.save(competitor27);
        Competitor savedCompetitor28 = competitorService.save(competitor28);
        Competitor savedCompetitor29 = competitorService.save(competitor29);


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

        StageLineItem stageLineItem5 = new StageLineItem();
        stageLineItem5.setStage(savedStage1);
        stageLineItem5.setCompetitor(savedCompetitor1);
        stageLineItem5.setTime(95.);
        stageLineItem5.setSprintPoints(10.);
        stageLineItem5.setMountainPoints(6.);

        StageLineItem stageLineItem6 = new StageLineItem();
        stageLineItem6.setStage(savedStage1);
        stageLineItem6.setCompetitor(savedCompetitor28);
        stageLineItem6.setTime(178.);
        stageLineItem6.setSprintPoints(5.);
        stageLineItem6.setMountainPoints(4.);

        StageLineItem stageLineItem7 = new StageLineItem();
        stageLineItem7.setStage(savedStage3);
        stageLineItem7.setCompetitor(savedCompetitor20);
        stageLineItem7.setTime(113.);
        stageLineItem7.setSprintPoints(5.);
        stageLineItem7.setMountainPoints(28.);

        StageLineItem stageLineItem8 = new StageLineItem();
        stageLineItem8.setStage(savedStage3);
        stageLineItem8.setCompetitor(savedCompetitor19);
        stageLineItem8.setTime(176.);
        stageLineItem8.setSprintPoints(17.);
        stageLineItem8.setMountainPoints(29.);

        StageLineItem stageLineItem9 = new StageLineItem();
        stageLineItem9.setStage(savedStage2);
        stageLineItem9.setCompetitor(savedCompetitor7);
        stageLineItem9.setTime(69.);
        stageLineItem9.setSprintPoints(13.);
        stageLineItem9.setMountainPoints(4.);

        StageLineItem stageLineItem10 = new StageLineItem();
        stageLineItem10.setStage(savedStage2);
        stageLineItem10.setCompetitor(savedCompetitor5);
        stageLineItem10.setTime(105.);
        stageLineItem10.setSprintPoints(28.);
        stageLineItem10.setMountainPoints(16.);

        StageLineItem stageLineItem11 = new StageLineItem();
        stageLineItem11.setStage(savedStage1);
        stageLineItem11.setCompetitor(savedCompetitor4);
        stageLineItem11.setTime(138.);
        stageLineItem11.setSprintPoints(15.);
        stageLineItem11.setMountainPoints(29.);

        StageLineItem stageLineItem12 = new StageLineItem();
        stageLineItem12.setStage(savedStage3);
        stageLineItem12.setCompetitor(savedCompetitor12);
        stageLineItem12.setTime(150.);
        stageLineItem12.setSprintPoints(26.);
        stageLineItem12.setMountainPoints(26.);

        StageLineItem stageLineItem13 = new StageLineItem();
        stageLineItem13.setStage(savedStage1);
        stageLineItem13.setCompetitor(savedCompetitor1);
        stageLineItem13.setTime(37.);
        stageLineItem13.setSprintPoints(2.);
        stageLineItem13.setMountainPoints(14.);

        StageLineItem stageLineItem14 = new StageLineItem();
        stageLineItem14.setStage(savedStage2);
        stageLineItem14.setCompetitor(savedCompetitor14);
        stageLineItem14.setTime(194.);
        stageLineItem14.setSprintPoints(25.);
        stageLineItem14.setMountainPoints(12.);

        StageLineItem stageLineItem15 = new StageLineItem();
        stageLineItem15.setStage(savedStage2);
        stageLineItem15.setCompetitor(savedCompetitor14);
        stageLineItem15.setTime(43.);
        stageLineItem15.setSprintPoints(14.);
        stageLineItem15.setMountainPoints(15.);

        StageLineItem stageLineItem16 = new StageLineItem();
        stageLineItem16.setStage(savedStage2);
        stageLineItem16.setCompetitor(savedCompetitor6);
        stageLineItem16.setTime(67.);
        stageLineItem16.setSprintPoints(13.);
        stageLineItem16.setMountainPoints(1.);

        StageLineItem stageLineItem17 = new StageLineItem();
        stageLineItem17.setStage(savedStage2);
        stageLineItem17.setCompetitor(savedCompetitor18);
        stageLineItem17.setTime(114.);
        stageLineItem17.setSprintPoints(30.);
        stageLineItem17.setMountainPoints(13.);

        StageLineItem stageLineItem18 = new StageLineItem();
        stageLineItem18.setStage(savedStage2);
        stageLineItem18.setCompetitor(savedCompetitor13);
        stageLineItem18.setTime(135.);
        stageLineItem18.setSprintPoints(15.);
        stageLineItem18.setMountainPoints(19.);

        StageLineItem stageLineItem19 = new StageLineItem();
        stageLineItem19.setStage(savedStage1);
        stageLineItem19.setCompetitor(savedCompetitor11);
        stageLineItem19.setTime(198.);
        stageLineItem19.setSprintPoints(9.);
        stageLineItem19.setMountainPoints(6.);

        StageLineItem stageLineItem20 = new StageLineItem();
        stageLineItem20.setStage(savedStage3);
        stageLineItem20.setCompetitor(savedCompetitor26);
        stageLineItem20.setTime(116.);
        stageLineItem20.setSprintPoints(5.);
        stageLineItem20.setMountainPoints(16.);

        StageLineItem stageLineItem21 = new StageLineItem();
        stageLineItem21.setStage(savedStage1);
        stageLineItem21.setCompetitor(savedCompetitor14);
        stageLineItem21.setTime(197.);
        stageLineItem21.setSprintPoints(7.);
        stageLineItem21.setMountainPoints(3.);

        StageLineItem stageLineItem22 = new StageLineItem();
        stageLineItem22.setStage(savedStage1);
        stageLineItem22.setCompetitor(savedCompetitor4);
        stageLineItem22.setTime(27.);
        stageLineItem22.setSprintPoints(11.);
        stageLineItem22.setMountainPoints(24.);

        StageLineItem stageLineItem23 = new StageLineItem();
        stageLineItem23.setStage(savedStage3);
        stageLineItem23.setCompetitor(savedCompetitor11);
        stageLineItem23.setTime(51.);
        stageLineItem23.setSprintPoints(5.);
        stageLineItem23.setMountainPoints(21.);

        StageLineItem stageLineItem24 = new StageLineItem();
        stageLineItem24.setStage(savedStage1);
        stageLineItem24.setCompetitor(savedCompetitor13);
        stageLineItem24.setTime(140.);
        stageLineItem24.setSprintPoints(6.);
        stageLineItem24.setMountainPoints(12.);

        StageLineItem stageLineItem25 = new StageLineItem();
        stageLineItem25.setStage(savedStage2);
        stageLineItem25.setCompetitor(savedCompetitor1);
        stageLineItem25.setTime(188.);
        stageLineItem25.setSprintPoints(28.);
        stageLineItem25.setMountainPoints(26.);

        StageLineItem stageLineItem26 = new StageLineItem();
        stageLineItem26.setStage(savedStage3);
        stageLineItem26.setCompetitor(savedCompetitor11);
        stageLineItem26.setTime(159.);
        stageLineItem26.setSprintPoints(14.);
        stageLineItem26.setMountainPoints(21.);

        StageLineItem stageLineItem27 = new StageLineItem();
        stageLineItem27.setStage(savedStage2);
        stageLineItem27.setCompetitor(savedCompetitor27);
        stageLineItem27.setTime(32.);
        stageLineItem27.setSprintPoints(12.);
        stageLineItem27.setMountainPoints(23.);

        StageLineItem stageLineItem28 = new StageLineItem();
        stageLineItem28.setStage(savedStage1);
        stageLineItem28.setCompetitor(savedCompetitor13);
        stageLineItem28.setTime(77.);
        stageLineItem28.setSprintPoints(15.);
        stageLineItem28.setMountainPoints(27.);

        StageLineItem stageLineItem29 = new StageLineItem();
        stageLineItem29.setStage(savedStage1);
        stageLineItem29.setCompetitor(savedCompetitor26);
        stageLineItem29.setTime(66.);
        stageLineItem29.setSprintPoints(9.);
        stageLineItem29.setMountainPoints(7.);

        StageLineItem stageLineItem30 = new StageLineItem();
        stageLineItem30.setStage(savedStage3);
        stageLineItem30.setCompetitor(savedCompetitor23);
        stageLineItem30.setTime(96.);
        stageLineItem30.setSprintPoints(24.);
        stageLineItem30.setMountainPoints(27.);

        StageLineItem stageLineItem31 = new StageLineItem();
        stageLineItem31.setStage(savedStage2);
        stageLineItem31.setCompetitor(savedCompetitor27);
        stageLineItem31.setTime(136.);
        stageLineItem31.setSprintPoints(11.);
        stageLineItem31.setMountainPoints(22.);

        StageLineItem stageLineItem32 = new StageLineItem();
        stageLineItem32.setStage(savedStage2);
        stageLineItem32.setCompetitor(savedCompetitor27);
        stageLineItem32.setTime(23.);
        stageLineItem32.setSprintPoints(12.);
        stageLineItem32.setMountainPoints(11.);

        StageLineItem stageLineItem33 = new StageLineItem();
        stageLineItem33.setStage(savedStage3);
        stageLineItem33.setCompetitor(savedCompetitor17);
        stageLineItem33.setTime(139.);
        stageLineItem33.setSprintPoints(14.);
        stageLineItem33.setMountainPoints(6.);

        StageLineItem stageLineItem34 = new StageLineItem();
        stageLineItem34.setStage(savedStage3);
        stageLineItem34.setCompetitor(savedCompetitor10);
        stageLineItem34.setTime(103.);
        stageLineItem34.setSprintPoints(3.);
        stageLineItem34.setMountainPoints(13.);

        StageLineItem stageLineItem35 = new StageLineItem();
        stageLineItem35.setStage(savedStage2);
        stageLineItem35.setCompetitor(savedCompetitor24);
        stageLineItem35.setTime(75.);
        stageLineItem35.setSprintPoints(3.);
        stageLineItem35.setMountainPoints(27.);

        StageLineItem stageLineItem36 = new StageLineItem();
        stageLineItem36.setStage(savedStage1);
        stageLineItem36.setCompetitor(savedCompetitor7);
        stageLineItem36.setTime(197.);
        stageLineItem36.setSprintPoints(8.);
        stageLineItem36.setMountainPoints(29.);

        StageLineItem stageLineItem37 = new StageLineItem();
        stageLineItem37.setStage(savedStage1);
        stageLineItem37.setCompetitor(savedCompetitor9);
        stageLineItem37.setTime(72.);
        stageLineItem37.setSprintPoints(17.);
        stageLineItem37.setMountainPoints(2.);

        StageLineItem stageLineItem38 = new StageLineItem();
        stageLineItem38.setStage(savedStage1);
        stageLineItem38.setCompetitor(savedCompetitor1);
        stageLineItem38.setTime(30.);
        stageLineItem38.setSprintPoints(5.);
        stageLineItem38.setMountainPoints(27.);

        StageLineItem stageLineItem39 = new StageLineItem();
        stageLineItem39.setStage(savedStage3);
        stageLineItem39.setCompetitor(savedCompetitor25);
        stageLineItem39.setTime(42.);
        stageLineItem39.setSprintPoints(7.);
        stageLineItem39.setMountainPoints(2.);

        StageLineItem stageLineItem40 = new StageLineItem();
        stageLineItem40.setStage(savedStage3);
        stageLineItem40.setCompetitor(savedCompetitor21);
        stageLineItem40.setTime(155.);
        stageLineItem40.setSprintPoints(15.);
        stageLineItem40.setMountainPoints(12.);

        StageLineItem stageLineItem41 = new StageLineItem();
        stageLineItem41.setStage(savedStage1);
        stageLineItem41.setCompetitor(savedCompetitor15);
        stageLineItem41.setTime(140.);
        stageLineItem41.setSprintPoints(16.);
        stageLineItem41.setMountainPoints(14.);

        StageLineItem stageLineItem42 = new StageLineItem();
        stageLineItem42.setStage(savedStage1);
        stageLineItem42.setCompetitor(savedCompetitor24);
        stageLineItem42.setTime(121.);
        stageLineItem42.setSprintPoints(14.);
        stageLineItem42.setMountainPoints(4.);

        StageLineItem stageLineItem43 = new StageLineItem();
        stageLineItem43.setStage(savedStage3);
        stageLineItem43.setCompetitor(savedCompetitor2);
        stageLineItem43.setTime(120.);
        stageLineItem43.setSprintPoints(4.);
        stageLineItem43.setMountainPoints(24.);

        StageLineItem stageLineItem44 = new StageLineItem();
        stageLineItem44.setStage(savedStage3);
        stageLineItem44.setCompetitor(savedCompetitor20);
        stageLineItem44.setTime(17.);
        stageLineItem44.setSprintPoints(14.);
        stageLineItem44.setMountainPoints(6.);

        StageLineItem stageLineItem45 = new StageLineItem();
        stageLineItem45.setStage(savedStage1);
        stageLineItem45.setCompetitor(savedCompetitor10);
        stageLineItem45.setTime(71.);
        stageLineItem45.setSprintPoints(7.);
        stageLineItem45.setMountainPoints(21.);

        StageLineItem stageLineItem46 = new StageLineItem();
        stageLineItem46.setStage(savedStage2);
        stageLineItem46.setCompetitor(savedCompetitor1);
        stageLineItem46.setTime(154.);
        stageLineItem46.setSprintPoints(9.);
        stageLineItem46.setMountainPoints(5.);

        StageLineItem stageLineItem47 = new StageLineItem();
        stageLineItem47.setStage(savedStage3);
        stageLineItem47.setCompetitor(savedCompetitor17);
        stageLineItem47.setTime(63.);
        stageLineItem47.setSprintPoints(14.);
        stageLineItem47.setMountainPoints(20.);

        StageLineItem stageLineItem48 = new StageLineItem();
        stageLineItem48.setStage(savedStage2);
        stageLineItem48.setCompetitor(savedCompetitor13);
        stageLineItem48.setTime(3.);
        stageLineItem48.setSprintPoints(14.);
        stageLineItem48.setMountainPoints(12.);

        StageLineItem stageLineItem49 = new StageLineItem();
        stageLineItem49.setStage(savedStage1);
        stageLineItem49.setCompetitor(savedCompetitor14);
        stageLineItem49.setTime(122.);
        stageLineItem49.setSprintPoints(2.);
        stageLineItem49.setMountainPoints(11.);

        StageLineItem stageLineItem50 = new StageLineItem();
        stageLineItem50.setStage(savedStage3);
        stageLineItem50.setCompetitor(savedCompetitor4);
        stageLineItem50.setTime(143.);
        stageLineItem50.setSprintPoints(19.);
        stageLineItem50.setMountainPoints(23.);

        StageLineItem stageLineItem51 = new StageLineItem();
        stageLineItem51.setStage(savedStage3);
        stageLineItem51.setCompetitor(savedCompetitor17);
        stageLineItem51.setTime(91.);
        stageLineItem51.setSprintPoints(28.);
        stageLineItem51.setMountainPoints(2.);

        StageLineItem stageLineItem52 = new StageLineItem();
        stageLineItem52.setStage(savedStage3);
        stageLineItem52.setCompetitor(savedCompetitor12);
        stageLineItem52.setTime(86.);
        stageLineItem52.setSprintPoints(25.);
        stageLineItem52.setMountainPoints(1.);

        StageLineItem stageLineItem53 = new StageLineItem();
        stageLineItem53.setStage(savedStage1);
        stageLineItem53.setCompetitor(savedCompetitor18);
        stageLineItem53.setTime(184.);
        stageLineItem53.setSprintPoints(28.);
        stageLineItem53.setMountainPoints(22.);

        StageLineItem stageLineItem54 = new StageLineItem();
        stageLineItem54.setStage(savedStage1);
        stageLineItem54.setCompetitor(savedCompetitor2);
        stageLineItem54.setTime(120.);
        stageLineItem54.setSprintPoints(19.);
        stageLineItem54.setMountainPoints(6.);

        StageLineItem stageLineItem55 = new StageLineItem();
        stageLineItem55.setStage(savedStage3);
        stageLineItem55.setCompetitor(savedCompetitor4);
        stageLineItem55.setTime(42.);
        stageLineItem55.setSprintPoints(25.);
        stageLineItem55.setMountainPoints(17.);

        StageLineItem stageLineItem56 = new StageLineItem();
        stageLineItem56.setStage(savedStage1);
        stageLineItem56.setCompetitor(savedCompetitor13);
        stageLineItem56.setTime(198.);
        stageLineItem56.setSprintPoints(5.);
        stageLineItem56.setMountainPoints(9.);

        StageLineItem stageLineItem57 = new StageLineItem();
        stageLineItem57.setStage(savedStage2);
        stageLineItem57.setCompetitor(savedCompetitor27);
        stageLineItem57.setTime(35.);
        stageLineItem57.setSprintPoints(6.);
        stageLineItem57.setMountainPoints(7.);

        StageLineItem stageLineItem58 = new StageLineItem();
        stageLineItem58.setStage(savedStage1);
        stageLineItem58.setCompetitor(savedCompetitor23);
        stageLineItem58.setTime(175.);
        stageLineItem58.setSprintPoints(27.);
        stageLineItem58.setMountainPoints(28.);

        StageLineItem stageLineItem59 = new StageLineItem();
        stageLineItem59.setStage(savedStage2);
        stageLineItem59.setCompetitor(savedCompetitor1);
        stageLineItem59.setTime(94.);
        stageLineItem59.setSprintPoints(10.);
        stageLineItem59.setMountainPoints(3.);

        StageLineItem stageLineItem60 = new StageLineItem();
        stageLineItem60.setStage(savedStage2);
        stageLineItem60.setCompetitor(savedCompetitor25);
        stageLineItem60.setTime(68.);
        stageLineItem60.setSprintPoints(1.);
        stageLineItem60.setMountainPoints(27.);

        StageLineItem stageLineItem61 = new StageLineItem();
        stageLineItem61.setStage(savedStage2);
        stageLineItem61.setCompetitor(savedCompetitor17);
        stageLineItem61.setTime(36.);
        stageLineItem61.setSprintPoints(6.);
        stageLineItem61.setMountainPoints(6.);

        StageLineItem stageLineItem62 = new StageLineItem();
        stageLineItem62.setStage(savedStage3);
        stageLineItem62.setCompetitor(savedCompetitor8);
        stageLineItem62.setTime(56.);
        stageLineItem62.setSprintPoints(23.);
        stageLineItem62.setMountainPoints(2.);

        StageLineItem stageLineItem63 = new StageLineItem();
        stageLineItem63.setStage(savedStage1);
        stageLineItem63.setCompetitor(savedCompetitor18);
        stageLineItem63.setTime(179.);
        stageLineItem63.setSprintPoints(29.);
        stageLineItem63.setMountainPoints(14.);

        StageLineItem stageLineItem64 = new StageLineItem();
        stageLineItem64.setStage(savedStage3);
        stageLineItem64.setCompetitor(savedCompetitor29);
        stageLineItem64.setTime(113.);
        stageLineItem64.setSprintPoints(12.);
        stageLineItem64.setMountainPoints(11.);

        StageLineItem stageLineItem65 = new StageLineItem();
        stageLineItem65.setStage(savedStage1);
        stageLineItem65.setCompetitor(savedCompetitor2);
        stageLineItem65.setTime(89.);
        stageLineItem65.setSprintPoints(27.);
        stageLineItem65.setMountainPoints(27.);

        StageLineItem stageLineItem66 = new StageLineItem();
        stageLineItem66.setStage(savedStage3);
        stageLineItem66.setCompetitor(savedCompetitor17);
        stageLineItem66.setTime(37.);
        stageLineItem66.setSprintPoints(20.);
        stageLineItem66.setMountainPoints(13.);

        StageLineItem stageLineItem67 = new StageLineItem();
        stageLineItem67.setStage(savedStage1);
        stageLineItem67.setCompetitor(savedCompetitor24);
        stageLineItem67.setTime(64.);
        stageLineItem67.setSprintPoints(14.);
        stageLineItem67.setMountainPoints(24.);

        StageLineItem stageLineItem68 = new StageLineItem();
        stageLineItem68.setStage(savedStage3);
        stageLineItem68.setCompetitor(savedCompetitor2);
        stageLineItem68.setTime(178.);
        stageLineItem68.setSprintPoints(20.);
        stageLineItem68.setMountainPoints(24.);

        StageLineItem stageLineItem69 = new StageLineItem();
        stageLineItem69.setStage(savedStage1);
        stageLineItem69.setCompetitor(savedCompetitor11);
        stageLineItem69.setTime(101.);
        stageLineItem69.setSprintPoints(11.);
        stageLineItem69.setMountainPoints(29.);

        StageLineItem stageLineItem70 = new StageLineItem();
        stageLineItem70.setStage(savedStage1);
        stageLineItem70.setCompetitor(savedCompetitor15);
        stageLineItem70.setTime(171.);
        stageLineItem70.setSprintPoints(27.);
        stageLineItem70.setMountainPoints(16.);

        StageLineItem stageLineItem71 = new StageLineItem();
        stageLineItem71.setStage(savedStage1);
        stageLineItem71.setCompetitor(savedCompetitor21);
        stageLineItem71.setTime(50.);
        stageLineItem71.setSprintPoints(18.);
        stageLineItem71.setMountainPoints(7.);

        StageLineItem stageLineItem72 = new StageLineItem();
        stageLineItem72.setStage(savedStage1);
        stageLineItem72.setCompetitor(savedCompetitor21);
        stageLineItem72.setTime(91.);
        stageLineItem72.setSprintPoints(27.);
        stageLineItem72.setMountainPoints(9.);

        StageLineItem stageLineItem73 = new StageLineItem();
        stageLineItem73.setStage(savedStage3);
        stageLineItem73.setCompetitor(savedCompetitor17);
        stageLineItem73.setTime(92.);
        stageLineItem73.setSprintPoints(22.);
        stageLineItem73.setMountainPoints(19.);

        StageLineItem stageLineItem74 = new StageLineItem();
        stageLineItem74.setStage(savedStage2);
        stageLineItem74.setCompetitor(savedCompetitor12);
        stageLineItem74.setTime(80.);
        stageLineItem74.setSprintPoints(9.);
        stageLineItem74.setMountainPoints(24.);

        StageLineItem stageLineItem75 = new StageLineItem();
        stageLineItem75.setStage(savedStage1);
        stageLineItem75.setCompetitor(savedCompetitor3);
        stageLineItem75.setTime(27.);
        stageLineItem75.setSprintPoints(13.);
        stageLineItem75.setMountainPoints(21.);

        StageLineItem stageLineItem76 = new StageLineItem();
        stageLineItem76.setStage(savedStage3);
        stageLineItem76.setCompetitor(savedCompetitor14);
        stageLineItem76.setTime(197.);
        stageLineItem76.setSprintPoints(7.);
        stageLineItem76.setMountainPoints(29.);

        StageLineItem stageLineItem77 = new StageLineItem();
        stageLineItem77.setStage(savedStage3);
        stageLineItem77.setCompetitor(savedCompetitor20);
        stageLineItem77.setTime(21.);
        stageLineItem77.setSprintPoints(27.);
        stageLineItem77.setMountainPoints(17.);

        StageLineItem stageLineItem78 = new StageLineItem();
        stageLineItem78.setStage(savedStage2);
        stageLineItem78.setCompetitor(savedCompetitor16);
        stageLineItem78.setTime(9.);
        stageLineItem78.setSprintPoints(19.);
        stageLineItem78.setMountainPoints(1.);

        StageLineItem stageLineItem79 = new StageLineItem();
        stageLineItem79.setStage(savedStage3);
        stageLineItem79.setCompetitor(savedCompetitor6);
        stageLineItem79.setTime(100.);
        stageLineItem79.setSprintPoints(18.);
        stageLineItem79.setMountainPoints(1.);

        StageLineItem stageLineItem80 = new StageLineItem();
        stageLineItem80.setStage(savedStage2);
        stageLineItem80.setCompetitor(savedCompetitor19);
        stageLineItem80.setTime(33.);
        stageLineItem80.setSprintPoints(29.);
        stageLineItem80.setMountainPoints(2.);

        StageLineItem stageLineItem81 = new StageLineItem();
        stageLineItem81.setStage(savedStage1);
        stageLineItem81.setCompetitor(savedCompetitor15);
        stageLineItem81.setTime(82.);
        stageLineItem81.setSprintPoints(13.);
        stageLineItem81.setMountainPoints(13.);

        StageLineItem stageLineItem82 = new StageLineItem();
        stageLineItem82.setStage(savedStage2);
        stageLineItem82.setCompetitor(savedCompetitor6);
        stageLineItem82.setTime(140.);
        stageLineItem82.setSprintPoints(3.);
        stageLineItem82.setMountainPoints(25.);

        StageLineItem stageLineItem83 = new StageLineItem();
        stageLineItem83.setStage(savedStage3);
        stageLineItem83.setCompetitor(savedCompetitor22);
        stageLineItem83.setTime(174.);
        stageLineItem83.setSprintPoints(14.);
        stageLineItem83.setMountainPoints(5.);

        StageLineItem stageLineItem84 = new StageLineItem();
        stageLineItem84.setStage(savedStage1);
        stageLineItem84.setCompetitor(savedCompetitor21);
        stageLineItem84.setTime(122.);
        stageLineItem84.setSprintPoints(29.);
        stageLineItem84.setMountainPoints(14.);

        StageLineItem stageLineItem85 = new StageLineItem();
        stageLineItem85.setStage(savedStage2);
        stageLineItem85.setCompetitor(savedCompetitor19);
        stageLineItem85.setTime(92.);
        stageLineItem85.setSprintPoints(5.);
        stageLineItem85.setMountainPoints(6.);

        StageLineItem stageLineItem86 = new StageLineItem();
        stageLineItem86.setStage(savedStage2);
        stageLineItem86.setCompetitor(savedCompetitor12);
        stageLineItem86.setTime(3.);
        stageLineItem86.setSprintPoints(22.);
        stageLineItem86.setMountainPoints(14.);

        StageLineItem stageLineItem87 = new StageLineItem();
        stageLineItem87.setStage(savedStage3);
        stageLineItem87.setCompetitor(savedCompetitor27);
        stageLineItem87.setTime(61.);
        stageLineItem87.setSprintPoints(13.);
        stageLineItem87.setMountainPoints(25.);

        StageLineItem stageLineItem88 = new StageLineItem();
        stageLineItem88.setStage(savedStage1);
        stageLineItem88.setCompetitor(savedCompetitor10);
        stageLineItem88.setTime(125.);
        stageLineItem88.setSprintPoints(6.);
        stageLineItem88.setMountainPoints(9.);

        StageLineItem stageLineItem89 = new StageLineItem();
        stageLineItem89.setStage(savedStage3);
        stageLineItem89.setCompetitor(savedCompetitor13);
        stageLineItem89.setTime(6.);
        stageLineItem89.setSprintPoints(13.);
        stageLineItem89.setMountainPoints(26.);

        stageLineItemService.save(stageLineItem1);
        stageLineItemService.save(stageLineItem2);
        stageLineItemService.save(stageLineItem3);
        stageLineItemService.save(stageLineItem4);
        stageLineItemService.save(stageLineItem5);
        stageLineItemService.save(stageLineItem6);
        stageLineItemService.save(stageLineItem7);
        stageLineItemService.save(stageLineItem8);
        stageLineItemService.save(stageLineItem9);
        stageLineItemService.save(stageLineItem10);
        stageLineItemService.save(stageLineItem11);
        stageLineItemService.save(stageLineItem12);
        stageLineItemService.save(stageLineItem13);
        stageLineItemService.save(stageLineItem14);
        stageLineItemService.save(stageLineItem15);
        stageLineItemService.save(stageLineItem16);
        stageLineItemService.save(stageLineItem17);
        stageLineItemService.save(stageLineItem18);
        stageLineItemService.save(stageLineItem19);
        stageLineItemService.save(stageLineItem20);
        stageLineItemService.save(stageLineItem21);
        stageLineItemService.save(stageLineItem22);
        stageLineItemService.save(stageLineItem23);
        stageLineItemService.save(stageLineItem24);
        stageLineItemService.save(stageLineItem25);
        stageLineItemService.save(stageLineItem26);
        stageLineItemService.save(stageLineItem27);
        stageLineItemService.save(stageLineItem28);
        stageLineItemService.save(stageLineItem29);
        stageLineItemService.save(stageLineItem30);
        stageLineItemService.save(stageLineItem31);
        stageLineItemService.save(stageLineItem32);
        stageLineItemService.save(stageLineItem33);
        stageLineItemService.save(stageLineItem34);
        stageLineItemService.save(stageLineItem35);
        stageLineItemService.save(stageLineItem36);
        stageLineItemService.save(stageLineItem37);
        stageLineItemService.save(stageLineItem38);
        stageLineItemService.save(stageLineItem39);
        stageLineItemService.save(stageLineItem40);
        stageLineItemService.save(stageLineItem41);
        stageLineItemService.save(stageLineItem42);
        stageLineItemService.save(stageLineItem43);
        stageLineItemService.save(stageLineItem44);
        stageLineItemService.save(stageLineItem45);
        stageLineItemService.save(stageLineItem46);
        stageLineItemService.save(stageLineItem47);
        stageLineItemService.save(stageLineItem48);
        stageLineItemService.save(stageLineItem49);
        stageLineItemService.save(stageLineItem50);
        stageLineItemService.save(stageLineItem51);
        stageLineItemService.save(stageLineItem52);
        stageLineItemService.save(stageLineItem53);
        stageLineItemService.save(stageLineItem54);
        stageLineItemService.save(stageLineItem55);
        stageLineItemService.save(stageLineItem56);
        stageLineItemService.save(stageLineItem57);
        stageLineItemService.save(stageLineItem58);
        stageLineItemService.save(stageLineItem59);
        stageLineItemService.save(stageLineItem60);
        stageLineItemService.save(stageLineItem61);
        stageLineItemService.save(stageLineItem62);
        stageLineItemService.save(stageLineItem63);
        stageLineItemService.save(stageLineItem64);
        stageLineItemService.save(stageLineItem65);
        stageLineItemService.save(stageLineItem66);
        stageLineItemService.save(stageLineItem67);
        stageLineItemService.save(stageLineItem68);
        stageLineItemService.save(stageLineItem69);
        stageLineItemService.save(stageLineItem70);
        stageLineItemService.save(stageLineItem71);
        stageLineItemService.save(stageLineItem72);
        stageLineItemService.save(stageLineItem73);
        stageLineItemService.save(stageLineItem74);
        stageLineItemService.save(stageLineItem75);
        stageLineItemService.save(stageLineItem76);
        stageLineItemService.save(stageLineItem77);
        stageLineItemService.save(stageLineItem78);
        stageLineItemService.save(stageLineItem79);
        stageLineItemService.save(stageLineItem80);
        stageLineItemService.save(stageLineItem81);
        stageLineItemService.save(stageLineItem82);
        stageLineItemService.save(stageLineItem83);
        stageLineItemService.save(stageLineItem84);
        stageLineItemService.save(stageLineItem85);
        stageLineItemService.save(stageLineItem86);
        stageLineItemService.save(stageLineItem87);
        stageLineItemService.save(stageLineItem88);
        stageLineItemService.save(stageLineItem89);
    }
}
