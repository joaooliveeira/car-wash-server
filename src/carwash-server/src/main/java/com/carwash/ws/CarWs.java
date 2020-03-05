package com.carwash.ws;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(value="sync/{date}", method = RequestMethod.GET)
	public List<Car> syncCar(@PathVariable("date") String lastSyncDate) throws ParseException {
		return carService.sync(lastSyncDate);
	}
	
}
