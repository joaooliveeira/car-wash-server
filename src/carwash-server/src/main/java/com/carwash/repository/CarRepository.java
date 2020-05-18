package com.carwash.repository;

import java.util.List;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carwash.model.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, String>, QuerydslPredicateExecutor<Car> {

	List<Car> findByLicensePlate(String licensePlate);
	 
	List<Car> findByCardNumber(String licensePlate);
	  
	List<Car> findByLicensePlateOrCardNumber(String licensePlate, String cardNumber);
	
	Car getByLicensePlate(String licensePlate);
	
}