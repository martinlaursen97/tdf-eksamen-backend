package com.code.tdfeksamenbackend.controller;

import com.code.tdfeksamenbackend.entity.Country;
import com.code.tdfeksamenbackend.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/countries")
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public ResponseEntity<List<Country>> fetchCountries() {
        List<Country> countries = countryService.findAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(countries);
    }

    @PostMapping
    public ResponseEntity<Country> createCountry(@RequestBody Country country) {
        Country savedCountry = countryService.save(country);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(savedCountry);
    }

}
