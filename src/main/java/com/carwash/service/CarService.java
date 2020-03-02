package com.carwash.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carwash.exception.CarWashException;
import com.carwash.model.Car;
import com.carwash.model.QCar;
import com.carwash.model.Wash;
import com.carwash.repository.CarRepository;
import com.querydsl.core.BooleanBuilder;

@Service
public class CarService {
	
	@Autowired
	private CarRepository carRepository;
	
	public Car create(Car car) {
		
		// Car fromDb = findById(car.getId());
		
		car.setLastUpdate(new Date());
		return carRepository.save(car);
		
	}
	
	public Car findById(String id) {
		return carRepository.findById(id).orElse(null);
	}
	
	public List<Car> findCar(String term) {
		
		BooleanBuilder builder = new BooleanBuilder();
		QCar qc = QCar.car;
		
		builder.andAnyOf(
				qc.licensePlate.containsIgnoreCase(term),
				qc.cardNumber.contains(term),
				qc.model.contains(term));
		
		List<Car> result = new ArrayList<>();
		
		carRepository.findAll(builder).forEach(result::add);
		
		return result;
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
