package com.example.my_backend;

import com.example.my_backend.controller.HouseController;
import com.example.my_backend.model.House;
import com.example.my_backend.service.HouseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
class MyBackendApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HouseService houseService;

    private House sampleHouse;

    @BeforeEach
    void setUp() {
        sampleHouse = new House(
                "Broker A", "For Sale", 300000.0, 3, 2, 0.5,
                "123 Main St", "CityA", "StateA", "12345", 1500.0, "2023-01-01"
        );
    }

    @Test
    void contextLoads() {
    }

    @Test
    void testSearchHouses() throws Exception {
        List<House> houses = Collections.singletonList(sampleHouse);

        when(houseService.searchHouses("CityA", null, null, null)).thenReturn(houses);

        mockMvc.perform(get("/api/search")
                        .param("city", "CityA"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].brokeredBy").value("Broker A"))
                .andExpect(jsonPath("$[0].price").value(300000.0))
                .andExpect(jsonPath("$[0].bed").value(3))
                .andExpect(jsonPath("$[0].city").value("CityA"));
    }

    @Test
    void testSearchHousesNoResults() throws Exception {
        when(houseService.searchHouses("NonExistentCity", null, null, null)).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/search")
                        .param("city", "NonExistentCity"))
                .andExpect(status().isOk())
                .andExpect(content().string("[]"));
    }

    @Test
    void testGetStats() throws Exception {
        List<Double> stats = Arrays.asList(300000.0, 0.5, 3.0);

        when(houseService.getCityStats("CityA", null, null, null)).thenReturn(stats);

        mockMvc.perform(get("/api/stats")
                        .param("city", "CityA"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]").value(300000.0))
                .andExpect(jsonPath("$[1]").value(0.5))
                .andExpect(jsonPath("$[2]").value(3.0));
    }

    @Test
    void testGetStatsNoResults() throws Exception {
        when(houseService.getCityStats("NonExistentCity", null, null, null)).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/stats")
                        .param("city", "NonExistentCity"))
                .andExpect(status().isOk())
                .andExpect(content().string("[]"));
    }
}
