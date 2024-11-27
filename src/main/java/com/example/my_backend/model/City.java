package com.example.my_backend.model;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

/**
 * Represents a city containing a collection of ZIP codes and their associated houses.
 */
public class City {
    private Map<String, ZIP> zipcodes;
    private String name;

    /**
     * Constructs a City object with the specified name.
     *
     * @param name the name of the city
     */
    public City(String name) {
        this.name = name;
        zipcodes = new HashMap<>();
    }

    /**
     * Adds a new ZIP code to the city.
     *
     * @param zipcode the ZIP code to be added
     */
    public void add(String zipcode) {
        ZIP newZip = new ZIP(zipcode);
        zipcodes.put(zipcode, newZip);
    }

    /**
     * Retrieves a list of all houses in the city.
     *
     * This method aggregates houses from all ZIP codes within the city.
     *
     * @return a {@link List} of {@link House} objects representing all houses in the city
     */
    public List<House> getHouses() {
        List<House> houses = new ArrayList<>();
        for (ZIP zipcode : zipcodes.values()) {
            houses.addAll(zipcode.getHouses());
        }
        return houses;
    }

    /**
     * Retrieves the map of ZIP codes in the city.
     *
     * @return a {@link Map} where the keys are ZIP code strings and the values are {@link ZIP} objects
     */
    public Map<String, ZIP> getZipcodes() {
        return zipcodes;
    }
}
