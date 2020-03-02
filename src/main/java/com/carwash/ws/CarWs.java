package com.carwash.ws;

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
	
	@RequestMapping(value="create", method = RequestMethod.PUT)
	public Car create(@RequestBody Car car) throws CarWashException {
		return carService.create(car);
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.GET)
	public Car findById(@PathVariable("id") String id) throws CarWashException {
		return carService.findById(id);
	}
	
	@RequestMapping(value="{licensePlate}", method = RequestMethod.GET)
	public Car findByLicensePlate(@PathVariable("licensePlate") String licensePlate) throws CarWashException {
		return carService.getByLicensePlate(licensePlate);
	}
	
	@RequestMapping(value="find/{term}", method = RequestMethod.GET)
	public List<Car> findCar(@PathVariable("term") String term) {
		return carService.findCar(term);
	}
	
//	@RequestMapping(value="sync/{lastUpdate}", method = RequestMethod.GET)
//	public List<Car> sync(@PathVariable("lastUpdate") Date lastUpdate) throws CarWashException {
//		return carService.sync(lastUpdate);
//	}
	
}
