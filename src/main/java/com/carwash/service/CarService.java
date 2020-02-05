package com.carwash.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carwash.exception.CarWashException;
import com.carwash.model.Car;
import com.carwash.repository.CarRepository;

@Service
public class CarService {
	
	@Autowired
	private CarRepository carRepository;
	
	public Car create(Car car) throws CarWashException {
		
		Car carFromDb = carRepository.findByLicensePlateOrCardNumber(car.getLicensePlate(), car.getCardNumber());
		
		if (carFromDb == null) {
			return carRepository.save(car);
		} else {
			throw new CarWashException("DUPLICATED_INFORMATION", "Erro no cadastro. Veículo já cadastrado.");
		}
	}
	
	public Car findCar(String licensePlate, String cardNumber) {
		return carRepository.findByLicensePlateOrCardNumber(licensePlate, cardNumber);
	}
	
	public Car getByLicensePlate(String licensePlate) {
		return carRepository.getByLicensePlate(licensePlate);
	}
	
	public Car getByCardNumber(String cardNumber) {
		return carRepository.getByCardNumber(cardNumber);
	}
	
	
	
}
