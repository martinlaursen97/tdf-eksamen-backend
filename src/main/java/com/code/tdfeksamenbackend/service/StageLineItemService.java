package com.code.tdfeksamenbackend.service;

import com.code.tdfeksamenbackend.constant.Discipline;
import com.code.tdfeksamenbackend.dto.CountryDTO;
import com.code.tdfeksamenbackend.dto.JerseyDTO;
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

    public JerseyDTO getJerseyOwner(Jersey jersey) {
        JerseyDTO jerseyDTO;

        switch (jersey) {
            case YELLOW -> {
                List<JerseyDTO> times = stageLineItemRepository.getTimes()
                        .orElseThrow(() -> new ApiBadRequestException("Bad request: " + jersey));

                jerseyDTO = times.stream()
                        .min(Comparator.comparing(JerseyDTO::getUnit))
                        .orElseThrow(() -> new ApiNotFoundException("Jersey not found: " + jersey));

            }
            case GREEN -> {
                List<JerseyDTO> times = stageLineItemRepository.getSprintPts()
                        .orElseThrow(() -> new ApiBadRequestException("Bad request: " + jersey));

                jerseyDTO = times.stream()
                        .max(Comparator.comparing(JerseyDTO::getUnit))
                        .orElseThrow(() -> new ApiNotFoundException("Jersey not found: " + jersey));
            }
            case POLKA -> {
                List<JerseyDTO> times = stageLineItemRepository.getMountainPts()
                        .orElseThrow(() -> new ApiBadRequestException("Bad request: " + jersey));

                jerseyDTO = times.stream()
                        .max(Comparator.comparing(JerseyDTO::getUnit))
                        .orElseThrow(() -> new ApiNotFoundException("Jersey not found: " + jersey));
            }
            case WHITE -> {
                List<JerseyDTO> times = stageLineItemRepository.getTimes()
                        .orElseThrow(() -> new ApiBadRequestException("Bad request: " + jersey));

                jerseyDTO = times.stream()
                        .filter(e -> e.getCompetitor().getAge() < 26)
                        .min(Comparator.comparing(JerseyDTO::getUnit))
                        .orElseThrow(() -> new ApiNotFoundException("Jersey not found: " + jersey));
            }
            default ->
                    throw new ApiBadRequestException("Bad request: " + jersey);
        }

        return jerseyDTO;
    }
}

