package com.example.my_backend.model;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
/**
 * Represents a state containing a collection of cities and their houses.
 */
public class State {
    private Map<String, City> cities;
    private String name;

    /**
     * Constructs a State object with the specified name.
     *
     * @param name the name of the state
     */
    public State(String name) {
        this.name = name;

        cities = new HashMap<String, City>();
    }

    /**
     * Adds a new city to the state.
     *
     * @param city the name of the city to be added
     */
    public void add(String city) {
        City newcity = new City(city);
        cities.put(city, newcity);
    }

    /**
     * Retrieves a list of all houses in the state.
     *
     * This method combines houses from all cities within the state.
     *
     * @return a {@link List} of {@link House} objects representing all houses in the state
     */
    public List<House> getHouses() {
        List<House> houses = new ArrayList<House>();
        for (City city : cities.values()) {
            houses.addAll(city.getHouses());
        }

        return houses;
    }

    /**
     * Retrieves the map of cities in the state.
     *
     * @return a {@link Map} where the keys are city names and the values are {@link City} objects
     */
    public Map<String, City> getCities() {
        return cities;
    }
}
