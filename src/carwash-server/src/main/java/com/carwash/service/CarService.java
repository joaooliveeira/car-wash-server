package com.carwash.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
		
		car.setLastUpdate(new Date());
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

	public List<Car> sync(String lastSyncDate) throws ParseException {
		
		BooleanBuilder builder = new BooleanBuilder();
		QCar qc = QCar.car;
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
		Date fromDate = formatter.parse(lastSyncDate);
		
		builder.and(qc.lastUpdate.after(fromDate));
		
		List<Car> result = new ArrayList<Car>();
		
		carRepository.findAll(builder).forEach(result::add);
		
		return result;
		
	}
	
//	public Car getByLicensePlate(String licensePlate) throws CarWashException {
//		Car fromDb = carRepository.getByLicensePlate(licensePlate);
//		
//		if(fromDb == null) {
//			throw new CarWashException("NOT_FOUND", "Placa não encontrada");
//		} else {
//			return fromDb;
//		}
//		
//	}
	
}
