package com.example.my_backend.model;

import java.util.Map;
import java.util.HashMap;

public class City {
    private Map<String, ZIP> zipcodes; 
    private String name;

    public City(String name) {
        this.name = name;

        zipcodes = new HashMap<String, ZIP>();
    }

    public String getName() {
        return name;
    }

    public void add(String zipcode) {
        ZIP newzip = new ZIP(zipcode);
        zipcodes.put(zipcode, newzip);
    }

    public Map<String, ZIP> getZipcodes() {
        return zipcodes;
    }

}