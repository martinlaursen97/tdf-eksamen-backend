package com.code.tdfeksamenbackend.service;

import com.code.tdfeksamenbackend.constant.Discipline;
import com.code.tdfeksamenbackend.dto.CountryDTO;
import com.code.tdfeksamenbackend.dto.CompetitorDTO;
import com.code.tdfeksamenbackend.entity.StageLineItem;
import com.code.tdfeksamenbackend.exception.ApiBadRequestException;
import com.code.tdfeksamenbackend.exception.ApiNotFoundException;
import com.code.tdfeksamenbackend.repository.StageLineItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.code.tdfeksamenbackend.constant.Jersey;

import java.util.Comparator;
import java.util.List;

@Service
public class StageLineItemService {

    private final StageLineItemRepository stageLineItemRepository;

    @Autowired
    public StageLineItemService(StageLineItemRepository stageLineItemRepository) {
        this.stageLineItemRepository = stageLineItemRepository;
    }

    public List<StageLineItem> findAll() {
        return stageLineItemRepository.findAll();
    }

    public StageLineItem save(StageLineItem stageLineItem) {
        return stageLineItemRepository.save(stageLineItem);
    }

    public List<CountryDTO> getCountryDTOByDiscipline(Discipline discipline) {
        List<CountryDTO> countryDTOS;

        switch (discipline) {
            case TIME -> countryDTOS  = stageLineItemRepository.getCountryTimes()
                    .orElseThrow(() -> new ApiNotFoundException("Not found: " + discipline));

            case SPRINT -> countryDTOS = stageLineItemRepository.getCountrySprintPts()
                    .orElseThrow(() -> new ApiNotFoundException("Not found: " + discipline));

            case MOUNTAIN -> countryDTOS = stageLineItemRepository.getCountryMountainPts()
                    .orElseThrow(() -> new ApiNotFoundException("Not found: " + discipline));

            default ->
                    throw new ApiBadRequestException("Bad request: " +  discipline);
        }
        return countryDTOS;
    }

    public CompetitorDTO getJerseyOwner(Jersey jersey) {
        CompetitorDTO competitorDTO;

        switch (jersey) {
            case YELLOW -> {
                List<CompetitorDTO> times = stageLineItemRepository.getTimes()
                        .orElseThrow(() -> new ApiBadRequestException("Bad request: " + jersey));

                competitorDTO = times.stream()
                        .min(Comparator.comparing(CompetitorDTO::getUnit))
                        .orElseThrow(() -> new ApiNotFoundException("Jersey not found: " + jersey));

            }
            case GREEN -> {
                List<CompetitorDTO> times = stageLineItemRepository.getSprintPts()
                        .orElseThrow(() -> new ApiBadRequestException("Bad request: " + jersey));

                competitorDTO = times.stream()
                        .max(Comparator.comparing(CompetitorDTO::getUnit))
                        .orElseThrow(() -> new ApiNotFoundException("Jersey not found: " + jersey));
            }
            case POLKA -> {
                List<CompetitorDTO> times = stageLineItemRepository.getMountainPts()
                        .orElseThrow(() -> new ApiBadRequestException("Bad request: " + jersey));

                competitorDTO = times.stream()
                        .max(Comparator.comparing(CompetitorDTO::getUnit))
                        .orElseThrow(() -> new ApiNotFoundException("Jersey not found: " + jersey));
            }
            case WHITE -> {
                List<CompetitorDTO> times = stageLineItemRepository.getTimes()
                        .orElseThrow(() -> new ApiBadRequestException("Bad request: " + jersey));

                competitorDTO = times.stream()
                        .filter(e -> e.getCompetitor().getAge() < 26)
                        .min(Comparator.comparing(CompetitorDTO::getUnit))
                        .orElseThrow(() -> new ApiNotFoundException("Jersey not found: " + jersey));
            }
            default ->
                    throw new ApiBadRequestException("Bad request: " + jersey);
        }

        return competitorDTO;
    }

    public List<CompetitorDTO> getCompetitorsSortedByBestTime() {
        return stageLineItemRepository.getCompetitorsSortedByBestTime()
                .orElseThrow(() -> new ApiNotFoundException("Competitors not found"));
    }
}

