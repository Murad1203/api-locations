package com.citiesapi.citiesapi.repository;

import com.citiesapi.citiesapi.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepo extends JpaRepository<City, Long> {
    public List<String> findCitiesBySettlement(String settlement);
}
