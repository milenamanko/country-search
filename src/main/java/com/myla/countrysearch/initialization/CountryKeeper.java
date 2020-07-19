package com.myla.countrysearch.initialization;

import com.myla.countrysearch.model.Country;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CountryKeeper {

    Map<String, Country> countryMap = new HashMap<>();

    void createCountryMap(List<Country> countries) {
        countries.forEach(c -> countryMap.put(c.getName(), c));
    }

    public Country getCountryByName(String countryName) {
        return countryMap.get(countryName);
    }

    public List<Country> getAllCountries() {
        return new ArrayList<>(countryMap.values());
    }
}
