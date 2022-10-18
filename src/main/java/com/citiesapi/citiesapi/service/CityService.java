package com.citiesapi.citiesapi.service;

import com.citiesapi.citiesapi.model.City;

import java.util.List;

public interface CityService {
    public List<City> getAllCities();
    public City getCitybyid(Long id);
    public List<City> getCitiesBySettlements(String settlement);
    public void save(City city);
    public void saveAllCities(List<City> cities);
    public void remove(long id);
}
