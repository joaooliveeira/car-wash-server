package com.carwash.repository;

import java.util.List;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carwash.model.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, String>, QuerydslPredicateExecutor<Car> {

	Car getById(String id);
	
	Car getByLicensePlateIgnoreCase(String licensePlate);
	
	Car getByCardNumber(String cardNumber);
	
	List<Car> findByLicensePlateContainingIgnoreCase(String licensePlate);
	
}