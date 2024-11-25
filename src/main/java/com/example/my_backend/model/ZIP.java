package com.example.my_backend.model;

import java.util.Set;
import java.util.HashSet;

public class ZIP {
    private Set<House> houses;
    private String zipcode;

    public ZIP(String zipcode) {
        this.zipcode = zipcode;

        houses = new HashSet<House>();
    }

    public String getCode() {
        return zipcode;
    }

    public void add(House newhouse) {
        houses.add(newhouse);
    }

    public Set<House> getHouses() {
        return houses;
    }


}