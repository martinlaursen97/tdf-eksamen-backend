package com.code.tdfeksamenbackend.service;

import com.code.tdfeksamenbackend.entity.Country;
import com.code.tdfeksamenbackend.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    public Country save(Country country) {
        return countryRepository.save(country);
    }
}
