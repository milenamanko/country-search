package com.myla.countrysearch.initialization;

import com.myla.countrysearch.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CountryInitializer implements CommandLineRunner {

    @Autowired
    private CountryFetcher countryFetcher;

    @Autowired
    private CountryKeeper countryKeeper;

    @Override
    public void run(String... args) throws Exception {
        List<Country> countries = countryFetcher.getCountries();
        countryKeeper.createCountryMap(countries);
    }

}
