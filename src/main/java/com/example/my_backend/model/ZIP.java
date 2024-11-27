package com.example.my_backend.model;

import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

/**
 * Represents a ZIP code area containing a set of houses.
 */
public class ZIP {
    private Set<House> houses;
    private String zipcode;

    /**
     * Constructs a ZIP object with the specified ZIP code.
     *
     * @param zipcode the ZIP code associated with this object
     */
    public ZIP(String zipcode) {
        this.zipcode = zipcode;

        houses = new HashSet<House>();
    }

    /**
     * Adds a new house to the set of houses in this ZIP code.
     *
     * @param newhouse the {@link House} object to be added
     */
    public void add(House newhouse) {
        houses.add(newhouse);
    }

    /**
     * Retrieves all houses in this ZIP code as a list.
     *
     * @return a {@link List} of {@link House} objects in this ZIP code
     */
    public List<House> getHouses() {
        List<House> housesList = new ArrayList<House>();

        housesList.addAll(houses);

        return housesList;
    }

}