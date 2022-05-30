package com.code.tdfeksamenbackend.dto;

import com.code.tdfeksamenbackend.entity.Competitor;
import com.code.tdfeksamenbackend.entity.Country;

public class CountryDTO {
    private Country country;
    private Double unit;

    public CountryDTO(Country country, Double unit) {
        this.country = country;
        this.unit = unit;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Double getUnit() {
        return unit;
    }

    public void setUnit(Double unit) {
        this.unit = unit;
    }
}
