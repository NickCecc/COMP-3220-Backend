package com.example.my_backend.model;

import java.util.Map;
import java.util.HashMap;

public class State {
    private Map<String, City> cities;
    private String name;

    public State(String name) {
        this.name = name;

        cities = new HashMap<String, City>();
    }

    public String getName() {
        return name;
    }

    public void add(String city) {
        City newcity = new City(city);
        cities.put(city, newcity);
    }

    public Map<String, City> getCities() {
        return cities;
    }

}