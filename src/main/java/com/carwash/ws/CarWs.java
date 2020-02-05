package com.carwash.ws;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@RequestMapping(value="", method = RequestMethod.POST)
	public Car create(@RequestBody Car car) throws CarWashException {
		return carService.create(car);
	}
	
	@RequestMapping(value="", method = RequestMethod.GET)
	public Car find(@RequestParam(name = "licensePlate",required = false) String licensePlate,
						@RequestParam(name = "cardNumber",required = false) String cardNumber) {
		return carService.findCar(licensePlate, cardNumber);
	}
	
//	@RequestMapping(value="{cardNumber}", method = RequestMethod.GET)
//	public Car getByCardNumber(@PathVariable("cardNumber") String cardNumber) {
//		return carService.getByCardNumber(cardNumber);
//	}
	
	
	
	
}
