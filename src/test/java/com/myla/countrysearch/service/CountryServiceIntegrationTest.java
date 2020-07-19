package com.myla.countrysearch.service;

import com.myla.countrysearch.model.Country;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CountryServiceIntegrationTest {

    @Autowired
    private CountryService countryService;

    @Test
    void getCountriesWithPopulationGreaterThanGiven800000000() {
        //GIVEN
        Integer population = 800000000;

        //WHEN
        List<Country> countries = countryService.getCountriesWithPopulationGreaterThan(population);

        //THEN
        assertThat(countries).hasSize(2);
        assertThat(countries).anyMatch(country -> country.getName().equals("India"));
        assertThat(countries).anyMatch(country -> country.getName().equals("China"));
    }

    @Test
    void getCountryByNameGivenPortugal() {
        //GIVEN
        String name = "Portugal";

        //WHEN
        Country country = countryService.getCountryByName(name);

        //THEN
        assertThat(country.getName()).isEqualTo("Portugal");
        assertThat(country.getCapital()).isEqualTo("Lisbon");
    }

    @Test
    void getCountriesWithBordersMoreThanGiven5() {
        //GIVEN
        int borderNumber = 7;

        //WHEN
        List<Country> countries = countryService.getCountriesWithBordersMoreThan(borderNumber);

        //THEN
        assertThat(countries).hasSize(12);

    }

    @Test
    void getCountriesWithDensityLowerThanGiven2() {
        //GIVEN
        int density = 2;

        //WHEN
        List<Country> countries = countryService.getCountriesWithDensityLowerThan(density);

        //THEN
        assertThat(countries).hasSize(9);
        assertThat(countries).anyMatch(country -> country.getName().equals("Antarctica"));
        assertThat(countries).anyMatch(country -> country.getName().equals("Greenland"));
        assertThat(countries).noneMatch(country -> country.getName().equals("India"));
    }

}