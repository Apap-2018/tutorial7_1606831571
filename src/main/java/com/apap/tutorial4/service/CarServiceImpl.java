package com.apap.tutorial4.service;
import com.apap.tutorial4.model.CarModel;
import com.apap.tutorial4.model.DealerModel;
import com.apap.tutorial4.repository.CarDb;
import com.apap.tutorial4.repository.DealerDb;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


@Service
@Transactional
public class CarServiceImpl implements CarService{
	@Autowired
	private CarDb carDb;
	
	@Override
	public CarModel addCar(CarModel car) {
		return carDb.save(car);
	}
	public void deleteCar(long carId) {
		// TODO Auto-generated method stub
		carDb.deleteById(carId);
	}
	public void updateCar(Long id, String amount, String brand, String price, String type) {
		carDb.getOne(id).setAmount(amount);
		carDb.getOne(id).setBrand(brand);
		carDb.getOne(id).setPrice(price);
		carDb.getOne(id).setType(type);
	}
	public Optional<CarModel> getCarDetailById(Long id){
		return carDb.findById(id);
	}
	@Override
	public void editCar(CarModel newCar, Long id) {
		// TODO Auto-generated method stub
		CarModel updatedCar = carDb.getOne(id);
		updatedCar.setAmount(newCar.getAmount());
		updatedCar.setBrand(newCar.getBrand());
		updatedCar.setPrice(newCar.getPrice());
		updatedCar.setType(newCar.getType());
		carDb.save(updatedCar);
	}
	@Override
	public List<CarModel> getAll() {
		// TODO Auto-generated method stub
		return  carDb.findAll();
	}

	
	}
	
	
	


