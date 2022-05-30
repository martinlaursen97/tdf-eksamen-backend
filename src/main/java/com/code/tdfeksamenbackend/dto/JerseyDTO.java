package com.code.tdfeksamenbackend.dto;

import com.code.tdfeksamenbackend.entity.Competitor;

public class JerseyDTO {
    private Competitor competitor;
    private Double unit;

    public JerseyDTO(Competitor competitor, Double unit) {
        this.competitor = competitor;
        this.unit = unit;
    }

    public Competitor getCompetitor() {
        return competitor;
    }

    public void setCompetitor(Competitor competitor) {
        this.competitor = competitor;
    }

    public Double getUnit() {
        return unit;
    }

    public void setUnit(Double unit) {
        this.unit = unit;
    }
}
