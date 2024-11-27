package com.example.my_backend.model;

import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

public class ZIP {
    private Set<House> houses;
    private String zipcode;

    public ZIP(String zipcode) {
        this.zipcode = zipcode;

        houses = new HashSet<House>();
    }

    /**
     * @param newhouse
     */
    public void add(House newhouse) {
        houses.add(newhouse);
    }

    /**
     * @return
     */
    public List<House> getHouses() {
        List<House> housesList = new ArrayList<House>();

        housesList.addAll(houses);

        return housesList;
    }

}