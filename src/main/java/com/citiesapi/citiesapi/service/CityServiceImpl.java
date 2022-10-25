package com.citiesapi.citiesapi.service;

import com.citiesapi.citiesapi.model.City;
import com.citiesapi.citiesapi.repository.CityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepo repository;
    @Override
    public List<City> getAllCities() {
        return repository.findAll();
    }

    @Override
    public City getCitybyid(Long id) {
        City city = null;
        Optional<City> city1 = repository.findById(id);
        if (city1.isPresent()) {
            city = city1.get();
        }
        return city;
    }
    @Override
    public List<City> getCitiesBySettlements(String settlement) {
        List<City> settlements = getAllCities();
        return findSettlements(settlements, settlement);
    }
    public List<City> findSettlements(List<City> settlements, String settlement) {

        List<City> res = settlements.stream()
                .filter((sett) -> sett.getSettlement().contains(settlement))
                .sorted((o1, o2) -> o2.getPopulation().compareTo(o1.getPopulation()))
                .limit(30)
                .collect(Collectors.toList());
        return res;
    }
    @Override
    public void save(City city) {
        repository.save(city);
    }
    @Override
    public void saveAllCities(List<City> cities) {
        cities.sort((o1, o2) -> o2.getSettlement().compareTo(o1.getSettlement()));
        repository.saveAll(cities);
    }

    @Override
    public void remove(long id) {
        repository.deleteById(id);
    }
}
