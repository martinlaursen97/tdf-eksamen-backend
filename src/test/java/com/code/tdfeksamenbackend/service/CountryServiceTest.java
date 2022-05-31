package com.code.tdfeksamenbackend.service;

import com.code.tdfeksamenbackend.entity.Country;
import com.code.tdfeksamenbackend.exception.ApiNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class CountryServiceTest {

    @Autowired
    private CountryService countryService;

    @Test
    void findCountryById() {
        Country country = countryService.save(new Country());
        long id = country.getId();
        Assertions.assertNotNull(countryService.findCountryById(id));
    }

    @Test
    void findCountryByIdThrowsException() {
        Long id = 0L;
        Assertions.assertThrows(ApiNotFoundException.class, () -> countryService.findCountryById(id));
    }
}