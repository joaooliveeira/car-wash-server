package com.carwash.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carwash.exception.CarWashException;
import com.carwash.model.Car;
import com.carwash.service.CarService;

@RestController
@RequestMapping(value="car")
public class CarWs {

	@Autowired
	private CarService carService;
	
	@RequestMapping(value="save", method = RequestMethod.PUT)
	public Car saveCar(@RequestBody Car car) throws CarWashException {
		return carService.save(car);
	}
	
	@RequestMapping(value="find/{term}", method = RequestMethod.GET)
	public List<Car> findCar(@PathVariable("term") String term) {
		return carService.find(term);
	}
	
	@RequestMapping(value="find/", method = RequestMethod.GET)
	public List<Car> findByLicensePlate(
			@RequestParam(name = "licensePlate", required = true) String licensePlate) {
		return carService.findCarByLicensePlate(licensePlate);
	}
	
	@RequestMapping(value="get/", method=RequestMethod.GET)
	public Car getCar(
			@RequestParam(name = "id", required = false) String id,
			@RequestParam(name = "licensePlate", required = false) String licensePlate,
			@RequestParam(name = "cardNumber", required = false) String cardNumber) {
		return carService.getCar(id, licensePlate, cardNumber);
	}
	
}
