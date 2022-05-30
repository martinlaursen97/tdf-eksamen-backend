package com.code.tdfeksamenbackend.service;

import com.code.tdfeksamenbackend.entity.Competitor;
import com.code.tdfeksamenbackend.exception.ApiBadRequestException;
import com.code.tdfeksamenbackend.exception.ApiNotFoundException;
import com.code.tdfeksamenbackend.repository.CompetitorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetitorService {

    private final CompetitorRepository competitorRepository;

    public CompetitorService(CompetitorRepository competitorRepository) {
        this.competitorRepository = competitorRepository;
    }

    public Page<Competitor> findAll(PageRequest pageRequest) {
        return competitorRepository.findAll(pageRequest);
    }

    public Competitor save(Competitor competitor) {
        return competitorRepository.save(competitor);
    }

    public void deleteCompetitorById(Long id) {
        competitorRepository.deleteById(id);
    }

    public List<Competitor> findAllByTeamId(Long id) {
        List<Competitor> competitors = competitorRepository
                .findAllByTeamId(id)
                .orElseThrow(() -> new ApiBadRequestException("Bad request"));

        if (competitors.size() == 0) {
            throw new ApiNotFoundException("No competitors found with team id: " + id);
        } else {
            return competitors;
        }
    }

    public Competitor findCompetitorById(Long id) {
        return competitorRepository.findById(id)
                .orElseThrow(() -> new ApiNotFoundException("Competitor not found with id: " + id));
    }

    public Competitor update(Competitor competitorToUpdate) {
        return competitorRepository.save(competitorToUpdate);
    }
}
