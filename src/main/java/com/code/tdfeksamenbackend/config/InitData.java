package com.code.tdfeksamenbackend.config;

import com.code.tdfeksamenbackend.service.CompetitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitData implements CommandLineRunner {

    private final CompetitorService competitorService;

    @Autowired
    public InitData(
            CompetitorService competitorService
    ) {
        this.competitorService = competitorService;
    }

    @Override
    public void run(String... args) {

    }
}
