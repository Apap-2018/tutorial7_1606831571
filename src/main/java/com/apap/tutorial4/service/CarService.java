package com.apap.tutorial4.service;

import java.util.List;
import java.util.Optional;

import com.apap.tutorial4.model.CarModel;
import com.apap.tutorial4.model.DealerModel;

public interface CarService {
	CarModel addCar(CarModel car);
	void deleteCar(long carId);
	void updateCar(Long id, String amount, String brand, String price, String type);
	Optional<CarModel> getCarDetailById(Long id);
	void editCar(CarModel newCar, Long id);
	List<CarModel> getAll();
}
