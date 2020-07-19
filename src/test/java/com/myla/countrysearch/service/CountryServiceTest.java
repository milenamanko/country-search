package com.myla.countrysearch.service;

import com.myla.countrysearch.initialization.CountryKeeper;
import com.myla.countrysearch.model.Country;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CountryServiceTest {

    @Mock
    private CountryKeeper countryKeeper;

    @InjectMocks
    private CountryService countryService;

    @Test
    void getCountiesWithPopulationGreaterThanGiven855() {
        //GIVEN
        List<Country> countries = buildCountries();
        when(countryKeeper.getAllCountries()).thenReturn(countries);

        //WHEN
        List<Country> result = countryService.getCountriesWithPopulationGreaterThan(855);

        //THEM
        assertThat(result).hasSize(1);
    }

    @Test
    void getCountriesWithBordersMoreThanGiven2() {
        //GIVEN
        List<Country> countries = buildCountries();
        when(countryKeeper.getAllCountries()).thenReturn(countries);

        //WHEN
        List<Country> result = countryService.getCountriesWithBordersMoreThan(2);

        //THEN
        assertThat(result).hasSize(2);
    }

    @Test
    void getCountriesWithBordersMoreThanGiven3() {
        //GIVEN
        List<Country> countries = buildCountries();
        when(countryKeeper.getAllCountries()).thenReturn(countries);

        //WHEN
        List<String> result = countryService.getCountriesWithBordersMoreThan(3).get(0).getBorders();

        //THEN
        assertThat(result).containsExactly("E", "G", "H", "F");
    }

    @Test
    void getCountriesWithDensityLowerThan7() {
        //GIVEN
        List<Country> countries = buildCountries();
        when(countryKeeper.getAllCountries()).thenReturn(countries);

        //WHEN
        List<Country> result = countryService.getCountriesWithDensityLowerThan(7);

        //THEN
        assertThat(result).isEmpty();
    }

    @Test
    void getCountiesWithPopulationGreaterThanGivenNullPopulation() {
        //GIVEN
        when(countryKeeper.getAllCountries()).thenReturn(Collections.singletonList(new Country("bobr", "a", 5.0, null, Arrays.asList("E", "G", "H", "F"))));

        //WHEN
        List<Country> result = countryService.getCountriesWithPopulationGreaterThan(3);

        //THEN
        assertThat(result).hasSize(0);
    }

    @Test
    void getCountiesWithPopulationGreaterThanGivenNullCountriesList() {
        //GIVEN
        when(countryKeeper.getAllCountries()).thenReturn(null);

        //WHEN
        org.junit.jupiter.api.Assertions.assertThrows(NullPointerException.class, () -> {
            countryService.getCountriesWithPopulationGreaterThan(1);
        });
    }

    @Test
    void getCountriesWithBordersMoreThanGivenEmptyCountriesList() {
        //GIVEN
        when(countryKeeper.getAllCountries()).thenReturn(new ArrayList<>());

        //WHEN
        List<Country> result = countryService.getCountriesWithBordersMoreThan(1);

        //THEN
        assertThat(result).hasSize(0);
    }

    @Test
    void getCountriesWithDensityLowerThanGivenArea0() {
        //GIVEN
        when(countryKeeper.getAllCountries()).thenReturn(Collections.singletonList(new Country("bobr", "a", 0, 8888, Arrays.asList("E", "G", "H", "F"))));

        //WHEN
        List <Country> result = countryService.getCountriesWithDensityLowerThan(5);

        //THEN
        assertThat(result).hasSize(0);
    }


    private List<Country> buildCountries() {
        return Arrays.asList(new Country("AAA", "a", 5.0, 855, Arrays.asList("E", "G", "H", "F")), new Country("BBB", "b", 77.0, 600, Arrays.asList("P", "Q")), new Country("CCC", "c", 8.5, 999, Arrays.asList("M", "N", "O")));
    }

}
