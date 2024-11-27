package com.example.my_backend.service;

import com.example.my_backend.model.*;
import com.example.my_backend.utils.CSVReaderUtil;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


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
        return houseList.filter(city, minPrice, maxPrice, minBed);
    }

    public List<Double> getCityStats(String city, Double minPrice, Double maxPrice, Integer minBed) {
        // Filter the list based on the criteria
        List<House> cityList = houseList.filter(city, minPrice, maxPrice, minBed);

        if (cityList.isEmpty()) {
            // Handle empty list case by returning zero averages
            return List.of(0.0, 0.0, 0.0);
        }

        // Calculate averages using Java Streams
        double avgPrice = cityList.stream().mapToDouble(House::getPrice).average().orElse(0.0);
        double avgBed = cityList.stream().mapToDouble(House::getBed).average().orElse(0.0);
        double avgSize = cityList.stream().mapToDouble(House::getAcreLot).average().orElse(0.0);

        // Return the averages as a list
        return List.of(avgPrice, avgSize, avgBed);
    }
}
