package com.carwash.service;

import java.util.Date;
import java.util.List;

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
		
		Car fromDb = findById(car.getId());
		
		if (fromDb == null) {
			car.setLastUpdate(new Date());
			return carRepository.save(car);
		} else {
			return update(fromDb.getId(), fromDb);
		}
	}
	
	public Car update(String id, Car car) throws CarWashException {
		
		Car fromDb = carRepository.findById(id).orElse(null);
		if (fromDb == null) {
			throw new CarWashException("Veículo não cadastrado");
		}
		
		fromDb.setModel(car.getModel());
		fromDb.setLicensePlate(car.getLicensePlate());
		fromDb.setCardNumber(car.getCardNumber());
		fromDb.setLastUpdate(new Date());
		
		return carRepository.save(fromDb);
	}
	
	public Car findById(String id) throws CarWashException {
		return carRepository.findById(id).orElse(null);
	}
	
	public Car findCar(String licensePlate, String cardNumber) {
		return carRepository.findByLicensePlateOrCardNumber(licensePlate, cardNumber);
	}
	
	public Car getByLicensePlate(String licensePlate) throws CarWashException {
		Car fromDb = carRepository.getByLicensePlate(licensePlate);
		
		if(fromDb == null) {
			throw new CarWashException("NOT_FOUND", "Placa não encontrada");
		} else {
			return fromDb;
		}
		
	}
	
	public Car getByCardNumber(String cardNumber) throws CarWashException {
		Car fromDb = carRepository.getByCardNumber(cardNumber);
		
		if(fromDb == null) {
			throw new CarWashException("NOT_FOUND", "Cartão não encontrado");
		} else {
			return fromDb;
		}
	}

//	public List<Car> sync(Date lastUpdate) {
//		return carRepository.findByStartDateAfter(lastUpdate);
//	}

}
