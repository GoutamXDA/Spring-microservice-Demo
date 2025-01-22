package com.ecom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.model.City;
import com.ecom.repository.CityRepository;

@Service
public class CityService {

	@Autowired
	private CityRepository cityRepository;
	
	public City getCityById(Long id) {
		return cityRepository.getOne(id);
	}
	
	public City saveCity(City city) {
		return cityRepository.save(city);
	}
}
