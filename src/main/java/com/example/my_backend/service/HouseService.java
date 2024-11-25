package com.example.my_backend.service;

import com.example.my_backend.model.*;
import com.example.my_backend.utils.CSVReaderUtil;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

import java.io.*;

@Service
public class HouseService {

    private Housing houseList;

    @EventListener(ContextRefreshedEvent.class)
    public void init() {
        // Load data from CSV file
        houseList = CSVReaderUtil.loadHouses("houses.csv");
        System.out.println("Housing data loaded.");
    }

    public List<House> searchHouses(String city, Double minPrice, Double maxPrice, Integer minBed) {

        List<House> filteredList = new ArrayList<House>();

        for(State stateObj : houseList.getStates().values()) {
            for(City cityObj : stateObj.getCities().values()) {
                boolean correctCity = (city == null || city.equalsIgnoreCase(cityObj.getName()));
                if(!correctCity) {
                    continue;
                }
                for(ZIP zipObj : cityObj.getZipcodes().values()) {
                    for(House house : zipObj.getHouses()) {
                        filteredList.add(house);
                    }
                }
            }
        }

        return filteredList.stream()
                .filter(h -> (city == null || h.getCity().equalsIgnoreCase(city)))
                .filter(h -> (minPrice == null || h.getPrice() >= minPrice))
                .filter(h -> (maxPrice == null || h.getPrice() <= maxPrice))
                .filter(h -> (minBed == null || h.getBed() >= minBed))
                .toList();
    }
}
