package com.example.my_backend.service;

import com.example.my_backend.model.*;
import com.example.my_backend.utils.CSVReaderUtil;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing housing data and providing business logic for searching and analyzing houses.
 */

@Service
public class HouseService {

    private Housing houseList;

    /**
     * Initializes the housing data from the CSV file when the application is refreshed.
     *
     * This method listens for the {@link ContextRefreshedEvent} and loads the housing data from
     * the "houses.csv" file using the {@link CSVReaderUtil}.
     */
    @EventListener(ContextRefreshedEvent.class)
    public void init() {
        // Load data from CSV file
        houseList = CSVReaderUtil.loadHouses("houses.csv");
        System.out.println("Housing data loaded.");
    }

    /**
     * Searches for houses based on the provided criteria.
     *
     * @param city     the name of the city to search in
     * @param minPrice the minimum price of the house
     * @param maxPrice the maximum price of the house
     * @param minBed   the minimum number of bedrooms
     * @return a list of {@link House} objects that match the search criteria
     */
    public List<House> searchHouses(String city, Double minPrice, Double maxPrice, Integer minBed) {
        return houseList.filter(city, minPrice, maxPrice, minBed);
    }

    /**
     * Calculates statistical averages for houses in a specified city that match the provided criteria.
     *
     * @param city     the name of the city to analyze (nullable)
     * @param minPrice the minimum price of the house (nullable)
     * @param maxPrice the maximum price of the house (nullable)
     * @param minBed   the minimum number of bedrooms (nullable)
     * @return a list of averages in the following order:
     *         <ol>
     *           <li>Average Price</li>
     *           <li>Average Lot Size (in acres)</li>
     *           <li>Average Number of Bedrooms</li>
     *         </ol>
     */
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
        double avgBath = cityList.stream().mapToDouble(House::getBath).average().orElse(0.0);

        // Return the averages as a list
        return List.of(avgPrice, avgSize, avgBed, avgBath);
    }
}
