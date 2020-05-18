package com.carwash.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carwash.exception.CarWashException;
import com.carwash.model.Car;
import com.carwash.model.QCar;
import com.carwash.model.QWash;
import com.carwash.repository.CarRepository;
import com.querydsl.core.BooleanBuilder;

@Service
public class CarService {
	
	@Autowired
	private CarRepository carRepository;
	
	public Car save(Car car) {
		return carRepository.save(car);
	}
	
	public List<Car> find(String term) {
		
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

	public Car getByLicensePlate(String licensePlate) {
		return carRepository.getByLicensePlate(licensePlate);
	}

	public List<Car> findByLicensePlate(String licensePlate) {
		return carRepository.findByLicensePlate(licensePlate);
	}

	public List<Car> findByLicensePlateOrCardNumber(String licensePlate, String cardNumber) {
		return carRepository.findByLicensePlateOrCardNumber(licensePlate, cardNumber);
	}
	
}
