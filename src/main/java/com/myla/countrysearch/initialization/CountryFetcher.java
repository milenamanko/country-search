package com.myla.countrysearch.initialization;

import com.myla.countrysearch.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class CountryFetcher {

    private static final String COUNTRIES_URL = "https://restcountries.eu/rest/v2/all";

    @Autowired
    private RestTemplate restTemplate;

    List<Country> getCountries() {
        Country[] countries = restTemplate.getForObject(COUNTRIES_URL, Country[].class);

        return Optional.ofNullable(countries)
                .map(Arrays::asList)
                .orElse(new ArrayList<>());
    }

}
