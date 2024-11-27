package com.example.my_backend.model;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Housing {

    public Map<String, State> states;

    public Housing() {
        states = new HashMap<String, State>();
    }

    public void add(String state) {
        State newstate = new State(state);
        states.put(state, newstate);
    }

    public Map<String, State> getStates() {
        return states;
    }

    public List<House> filter(String city, Double minPrice, Double maxPrice, Integer minBed) {
        return this.getHouses().stream()
                .filter(h -> (city == null || h.getCity().equalsIgnoreCase(city)))
                .filter(h -> (minPrice == null || h.getPrice() >= minPrice))
                .filter(h -> (maxPrice == null || h.getPrice() <= maxPrice))
                .filter(h -> (minBed == null || h.getBed() >= minBed))
                .toList();
    }

    private List<House> getHouses() {
        List<House> houses = new ArrayList<House>();
        for (State state : states.values()) {
            houses.addAll(state.getHouses());
        }

        return houses;
    }


}