package com.carwash.repository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carwash.model.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, String>, QuerydslPredicateExecutor<Car> {

	Car findByLicensePlate(String licensePlate);
	 
	Car findByCardNumber(String licensePlate);
	  
	Car findByLicensePlateOrCardNumber(String licensePlate, String cardNumber);
	
	void deleteById(String id);
	
}