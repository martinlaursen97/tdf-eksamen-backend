package com.code.tdfeksamenbackend.config;

import com.code.tdfeksamenbackend.entity.Competitor;
import com.code.tdfeksamenbackend.entity.Country;
import com.code.tdfeksamenbackend.entity.Team;
import com.code.tdfeksamenbackend.service.CompetitorService;
import com.code.tdfeksamenbackend.service.CountryService;
import com.code.tdfeksamenbackend.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitData implements CommandLineRunner {

    private final CompetitorService competitorService;
    private final CountryService countryService;
    private final TeamService teamService;

    @Autowired
    public InitData(
            CompetitorService competitorService,
            CountryService countryService,
            TeamService teamService
    ) {
        this.competitorService = competitorService;
        this.countryService = countryService;
        this.teamService = teamService;
    }

    @Override
    public void run(String... args) {
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
        competitor1.setCountry(savedCountry1);
        competitor1.setTeam(savedTeam1);

        Competitor competitor2 = new Competitor();
        competitor2.setFirstName("Kenned");
        competitor2.setLastName("Larsen");
        competitor2.setCountry(savedCountry2);
        competitor2.setTeam(savedTeam2);

        competitorService.save(competitor1);
        competitorService.save(competitor2);
    }
}
