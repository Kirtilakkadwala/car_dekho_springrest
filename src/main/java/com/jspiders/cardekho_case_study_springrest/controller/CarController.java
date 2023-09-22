package com.jspiders.cardekho_case_study_springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.cardekho_case_study_springrest.pojo.CarPOJO;
import com.jspiders.cardekho_case_study_springrest.response.CarResponse;
import com.jspiders.cardekho_case_study_springrest.service.CarService;

@RestController
public class CarController {
	@Autowired
	private CarService service;
	
	@PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CarResponse> addStudent(@RequestBody CarPOJO pojo) {

		CarPOJO  car = service.addCar(pojo);

		// SUCCESS
		if (car != null) {
			return new ResponseEntity<CarResponse>(new CarResponse("Data added successfully. ", car, null),
					HttpStatus.ACCEPTED);
		}

		// FAILURE
		
		return new ResponseEntity<CarResponse>(new CarResponse("Data not added. ", null, null),
				HttpStatus.NOT_ACCEPTABLE);
}
	
	@GetMapping(path = "/search/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CarResponse> searchCar(@PathVariable int id) {
		CarPOJO car = service.searchCar(id);

		// SUCCESS
		if (car != null) {
			return new ResponseEntity<CarResponse>(new CarResponse("Data found successfully. ", car, null),
					HttpStatus.FOUND);
		}

		// FAILURE
		return new ResponseEntity<CarResponse>(new CarResponse("Data not found. ", car, null),
				HttpStatus.NOT_FOUND);
	}

	@GetMapping(path = "/searchAllCars", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CarResponse> searchAllStudents() {
		List<CarPOJO> cars = service.searchAllCar();

		// SUCCESS
		if (cars.isEmpty() == false) {
			return new ResponseEntity<CarResponse>(new CarResponse("Data found successfully. ", null, cars),
					HttpStatus.FOUND);				
		}

		// FAILURE
		return new ResponseEntity<CarResponse>(new CarResponse("Data not found. ", null, null),
				HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping(path = "/remove/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CarResponse> removeStudent(@PathVariable int id) {
		CarPOJO car = service.removeCar(id);

		// SUCCESS
		if (car != null) {
			return new ResponseEntity<CarResponse>(
					new CarResponse("Data removed successfully. ", car, null), HttpStatus.OK);
		}

		// FAILURE
		return new ResponseEntity<CarResponse>(new CarResponse("Data not removed. ", null, null),
				HttpStatus.BAD_REQUEST);
	}

	@PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CarResponse> updateCar(@RequestBody CarPOJO pojo) {
		CarPOJO student = service.updateStudent(pojo);

		// SUCCESS
		if (student != null) {
			return new ResponseEntity<CarResponse>(
					new CarResponse("Data updated successfully. ", student, null), HttpStatus.ACCEPTED);
		}

		// FAILURE
		return new ResponseEntity<CarResponse>(new CarResponse("Data not updated. ", null, null),
				HttpStatus.NOT_ACCEPTABLE);
	}
}
