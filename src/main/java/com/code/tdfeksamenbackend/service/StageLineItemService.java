package com.code.tdfeksamenbackend.service;


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

    public JerseyDTO getJerseyOwner(Jersey jersey) {
        List<StageLineItem> stageLineItems = stageLineItemRepository.findAll();
        StageLineItem stageLineItem;

        switch (jersey) {
            case YELLOW -> {
                stageLineItem = stageLineItems.stream()
                        .min(Comparator.comparing(StageLineItem::getTime))
                        .orElseThrow(() -> new ApiNotFoundException("Jersey not found: " + jersey));
                return new JerseyDTO(stageLineItem.getCompetitor(), stageLineItem.getTime());
            }


            case GREEN -> {
                stageLineItem = stageLineItems.stream()
                        .max(Comparator.comparing(StageLineItem::getSprintPoints))
                        .orElseThrow(() -> new ApiNotFoundException("Jersey not found: " + jersey));
                return new JerseyDTO(stageLineItem.getCompetitor(), stageLineItem.getSprintPoints());

            }

            case POLKA -> {
                stageLineItem = stageLineItems.stream()
                        .max(Comparator.comparing(StageLineItem::getMountainPoints))
                        .orElseThrow(() -> new ApiNotFoundException("Jersey not found: " + jersey));
                return new JerseyDTO(stageLineItem.getCompetitor(), stageLineItem.getMountainPoints());
            }

            case WHITE -> {
                stageLineItem = stageLineItems.stream()
                        .filter(sli -> sli.getCompetitor().getAge() < 26)
                        .min(Comparator.comparing(StageLineItem::getTime))
                        .orElseThrow(() -> new ApiNotFoundException("Jersey not found: " + jersey));
                return new JerseyDTO(stageLineItem.getCompetitor(), stageLineItem.getTime());
            }

            default -> throw new ApiBadRequestException("Bad request: " + jersey);
        }
    }
}
