package com.myla.countrysearch.initialization;

import com.myla.countrysearch.model.Country;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;


@ExtendWith(MockitoExtension.class)
class CountryFetcherTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private CountryFetcher countryFetcher;

    @Test
    void getCountriesGivenNullCountriesArray() {
        //GIVEN
        Mockito.when(restTemplate.getForObject("https://restcountries.eu/rest/v2/all", Country[].class)).thenReturn(null);

        //WHEN
        List<Country> result = countryFetcher.getCountries();

        //THEN
        Assertions.assertThat(result).hasSize(0);

    }

    @Test
    void getCountriesGivenValidCountriesArray() {
        //GIVEN
        Country[] countries = new Country[]{(new Country("AAA", "a", 5.0, 855, Arrays.asList("E", "G", "H", "F"))), new Country("BBB", "b", 77.0, 600, Arrays.asList("P", "Q")), new Country("CCC", "c", 8.5, 999, Arrays.asList("M", "N", "O"))};
        Mockito.when(restTemplate.getForObject("https://restcountries.eu/rest/v2/all", Country[].class)).thenReturn(countries);

        //WHEN
        List<Country> result = countryFetcher.getCountries();

        //THEN
        Assertions.assertThat(result).hasSize(3);

    }

}