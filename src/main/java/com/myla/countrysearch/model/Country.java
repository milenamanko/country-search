package com.myla.countrysearch.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Country {

    private String name;

    private String capital;

    private double area;

    private Integer population;

    private List<String> borders;

}
