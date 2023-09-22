package com.jspiders.cardekho_case_study_springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.cardekho_case_study_springrest.pojo.CarPOJO;
import com.jspiders.cardekho_case_study_springrest.repository.CarRepository;
import com.jspiders.cardekho_case_study_springrest.response.CarResponse;

@Service
public class CarService {
	@Autowired
	private CarRepository repository;
	public CarPOJO addCar(CarPOJO pojo) {
		CarPOJO car = repository.addCar(pojo);
		return car;
	}
	public CarPOJO searchCar(int id) {
		CarPOJO car = repository.searchCar(id);
		return car;
	}
	public List<CarPOJO> searchAllCar() {
		List<CarPOJO> cars = repository.searchAllStudent();
		return cars;
	}
	public CarPOJO removeCar(int id) {
		CarPOJO car = repository.removeCar(id);
		return car;
	}
	public CarPOJO updateStudent(CarPOJO pojo) {
		CarPOJO car = repository.updateCar(pojo);
		return car;
	}

}
