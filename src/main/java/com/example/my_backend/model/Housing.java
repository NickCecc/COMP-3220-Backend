package com.example.my_backend.model;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a collection of states and provides functionality to manage and filter housing data.
 */
public class Housing {

    public Map<String, State> states;

    /**
     * Constructs a Housing object with an empty collection of states.
     */
    public Housing() {
        states = new HashMap<>();
    }

    /**
     * Adds a new state to the housing collection.
     *
     * @param state the name of the state to be added
     */
    public void add(String state) {
        State newState = new State(state);
        states.put(state, newState);
    }

    /**
     * Retrieves the map of states in the housing collection.
     *
     * @return a {@link Map} where the keys are state names and the values are {@link State} objects
     */
    public Map<String, State> getStates() {
        return states;
    }

    /**
     * Filters houses based on the provided criteria.
     *
     * This method searches all houses within the housing collection and filters them based on
     * the provided parameters:
     * <ul>
     *     <li>City: Matches the city name (case-insensitive)</li>
     *     <li>Minimum Price: Filters houses with a price greater than or equal to this value</li>
     *     <li>Maximum Price: Filters houses with a price less than or equal to this value</li>
     *     <li>Minimum Beds: Filters houses with a number of bedrooms greater than or equal to this value</li>
     * </ul>
     *
     * @param city     the name of the city to filter by (nullable)
     * @param minPrice the minimum price of the house (nullable)
     * @param maxPrice the maximum price of the house (nullable)
     * @param minBed   the minimum number of bedrooms (nullable)
     * @return a {@link List} of {@link House} objects matching the filter criteria
     */
    public List<House> filter(String city, Double minPrice, Double maxPrice, Integer minBed) {
        return this.getHouses().stream()
                .filter(h -> (city == null || h.getCity().equalsIgnoreCase(city)))
                .filter(h -> (minPrice == null || h.getPrice() >= minPrice))
                .filter(h -> (maxPrice == null || h.getPrice() <= maxPrice))
                .filter(h -> (minBed == null || h.getBed() >= minBed))
                .toList();
    }

    /**
     * Retrieves a list of all houses in the housing collection.
     *
     * This method combines houses from all states within the collection.
     *
     * @return a {@link List} of {@link House} objects
     */
    private List<House> getHouses() {
        List<House> houses = new ArrayList<>();
        for (State state : states.values()) {
            houses.addAll(state.getHouses());
        }
        return houses;
    }
}
