package com.ecom.reset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.model.City;
import com.ecom.service.CityService;

@RestController
@RequestMapping("/api")
public class CityRestController {

	@Autowired
	private CityService cityService;
	
	@GetMapping("/cities/{id}")
	public ResponseEntity<City> getCityById(@PathVariable(name="id") Long id){
		return new ResponseEntity<>(cityService.getCityById(id),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<City> saveCity(@RequestBody City city){
		return new ResponseEntity<>(cityService.saveCity(city),HttpStatus.CREATED);
	}
}
