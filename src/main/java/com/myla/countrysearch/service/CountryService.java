package com.myla.countrysearch.service;

import com.myla.countrysearch.initialization.CountryKeeper;
import com.myla.countrysearch.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryService {

    @Autowired
    private CountryKeeper countryKeeper;

    public List<Country> getCountriesWithPopulationGreaterThan(Integer population) {
        return countryKeeper.getAllCountries()
                .stream()
                .filter(c -> c.getPopulation() > population)
                .collect(Collectors.toList());
    }

    public Country getCountryByName(String name) {
        return countryKeeper.getCountryByName(name);
    }

    public List<Country> getCountriesWithBordersMoreThan(int number) {
        return countryKeeper.getAllCountries()
                .stream()
                .filter(country -> country.getBorders().size() > number)
                .collect(Collectors.toList());
    }

    public List<Country> getCountriesWithDensityLowerThan(int number) {
        return countryKeeper.getAllCountries()
                .stream()
                .filter(c -> c.getPopulation()/c.getArea() < number)
                .collect(Collectors.toList());
    }
}
