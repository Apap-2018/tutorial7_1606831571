package com.apap.tutorial4.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.apap.tutorial4.model.CarModel;
import com.apap.tutorial4.model.DealerModel;
import com.apap.tutorial4.service.CarService;
import com.apap.tutorial4.service.DealerService;

@RestController
@RequestMapping("/car")
public class CarController{
	@Autowired
	private CarService carService;
	private DealerService dealerService;
	

	@DeleteMapping(value= "/delete/{carId}")
	private String deleteCar(@PathVariable("carId") long carId, Model model) {
		carService.deleteCar(carId);
		return "Success";
	}
	@PostMapping(value= "/add")
	private CarModel addCarSubmit(@RequestBody CarModel car) {
		//return dealerService.addDealer(dealer);
		return carService.addCar(car);
	}
	@PutMapping(value = "{id}")
	private String updateCarSubmit(
			@PathVariable(value = "id") long id,
			@RequestParam(value = "brand", required = false) String brand,
			@RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "price", required = false) String price,
			@RequestParam(value = "amount", required = false) String amount,
			@RequestParam(value = "dealerID", required = false) String dealerID
			){
		CarModel car = carService.getCarDetailById(id).get();
		if (car == null) {
			return "Car is uknown";
		}
		if (!(brand == null)) {
			car.setBrand(brand);
		}
		if (!(type == null)) {
			car.setType(type);
		}
		if (!(price == null)) {
			car.setPrice(Long.valueOf(price));
		}
		if (!(amount == null)) {
			car.setAmount(Integer.parseInt(amount));
		}
		if (!(dealerID == null)) {
			DealerModel dealer = dealerService.getDealerDetailById(Long.valueOf(dealerID)).get();
			car.setDealer(dealer);
		}
		carService.editCar(car, id);
		return "success";
	}
	@GetMapping(value = "/{id}")
	private CarModel viewCar(@PathVariable("id") long id) {
		CarModel car = carService.getCarDetailById(id).get();
		return car;
	}

	@GetMapping(value = "/all")
	private List<CarModel> viewAllCar() {
		List<CarModel> listCar = carService.getAll();
		for (CarModel car: listCar) {
			car.setDealer(null);
		}
		return listCar;
	}
	
	
	
	
	
	
}