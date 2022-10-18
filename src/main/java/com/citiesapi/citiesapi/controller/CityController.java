package com.citiesapi.citiesapi.controller;

import com.citiesapi.citiesapi.model.City;
import com.citiesapi.citiesapi.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class CityController {
    @Autowired
    private CityService cityService;

    @CrossOrigin
    @GetMapping("/cities")
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }

    @CrossOrigin
    @GetMapping("/byCities/{settlement}")
    public List<City> getCitiesBySettlement(@PathVariable String settlement) {
        return cityService.getCitiesBySettlements(settlement);
    }

    @PostMapping("/save")
    public City saveCity(@RequestBody City city) {
        cityService.save(city);
        return city;
    }

    @PostMapping("/save-all")
    public String saveAll(@RequestBody List<City> cities) {
        cityService.saveAllCities(cities);
        return "All Cities is true save";
    }
 }
