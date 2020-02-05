package com.carwash.repository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carwash.model.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, Long>, QuerydslPredicateExecutor<Car> {

  Car getByLicensePlate(String licensePlate);
  Car getByCardNumber(String cardNumber);
  Car findByLicensePlateOrCardNumber(String licensePlate, String cardNumber);

}