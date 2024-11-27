package com.example.my_backend.controller;

import com.example.my_backend.model.House;
import com.example.my_backend.service.HouseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for handling requests related to houses.
 *
 * This controller provides endpoints for searching houses and retrieving statistics
 * based on specified criteria.
 */

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class HouseController {

    private final HouseService houseService;

    /**
     * Constructs a {@code HouseController} with the specified {@code HouseService}.
     *
     * @param houseService the service used to handle house-related operations
     */
    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    /**
     * Searches for houses based on the provided criteria.
     *
     * This endpoint allows filtering by city, minimum price, maximum price,
     * and minimum number of bedrooms.
     *
     * @param city     the name of the city to filter by
     * @param minPrice the minimum price of the house
     * @param maxPrice the maximum price of the house
     * @param minBed   the minimum number of bedrooms
     * @return a {@link List} of {@link House} objects matching the criteria
     */
    @GetMapping("/search")
    public List<House> searchHouses(@RequestParam(required = false) String city,
                                    @RequestParam(required = false) Double minPrice,
                                    @RequestParam(required = false) Double maxPrice,
                                    @RequestParam(required = false) Integer minBed) {
        return houseService.searchHouses(city, minPrice, maxPrice, minBed);
    }

    /**
     * Retrieves statistics for houses based on the given criteria.
     *
     * This endpoint calculates averages for price, lot size, and number of bedrooms
     * for houses matching the optional filters.
     *
     * @param city     the name of the city to filter by
     * @param minPrice the minimum price of the house
     * @param maxPrice the maximum price of the house
     * @param minBed   the minimum number of bedrooms
     * @return a {@link List} of {@link Double} values representing the averages:
     *         <ol>
     *             <li>Average Price</li>
     *             <li>Average Lot Size (in acres)</li>
     *             <li>Average Number of Bedrooms</li>
     *         </ol>
     */
    @GetMapping("/stats")
    public List<Double> getStats(
            @RequestParam(required = false) String city,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) Integer minBed
    ){

        return houseService.getCityStats(city, minPrice, maxPrice, minBed);
    }
}
