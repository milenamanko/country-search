package com.myla.countrysearch.initialization;

import com.myla.countrysearch.model.Country;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CountryInitializerTest {

    @Mock
    private CountryKeeper countryKeeper;

    @Mock
    private CountryFetcher countryFetcher;

    @InjectMocks
    private CountryInitializer countryInitializer;

    @Test
    void run() throws Exception {
        //GIVEN
        List<Country> countries = new ArrayList<>();
        when(countryFetcher.getCountries()).thenReturn(countries);

        //WHEN
        countryInitializer.run();

        //THEN
        verify(countryKeeper).createCountryMap(countries);
    }

}