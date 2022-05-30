package com.code.tdfeksamenbackend.service;

import com.code.tdfeksamenbackend.entity.Competitor;
import com.code.tdfeksamenbackend.repository.CompetitorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetitorService {

    private final CompetitorRepository competitorRepository;

    public CompetitorService(CompetitorRepository competitorRepository) {
        this.competitorRepository = competitorRepository;
    }

    public List<Competitor> findAll() {
        return competitorRepository.findAll();
    }

    public Competitor save(Competitor competitor) {
        return competitorRepository.save(competitor);
    }

    public void deleteCompetitorById(Long id) {
        competitorRepository.deleteById(id);
    }

    public List<Competitor> findAllByTeamId(Long id) {
        return competitorRepository.findAllByTeamId(id).orElseThrow();
    }
}
