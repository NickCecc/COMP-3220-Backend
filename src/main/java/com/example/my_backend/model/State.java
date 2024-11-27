package com.example.my_backend.model;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class State {
    private Map<String, City> cities;
    private String name;

    public State(String name) {
        this.name = name;

        cities = new HashMap<String, City>();
    }

    public void add(String city) {
        City newcity = new City(city);
        cities.put(city, newcity);
    }

    public List<House> getHouses() {
        List<House> houses = new ArrayList<House>();
        for (City city : cities.values()) {
            houses.addAll(city.getHouses());
        }

        return houses;
    }

    public Map<String, City> getCities() {
        return cities;
    }
}
