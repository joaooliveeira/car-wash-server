package com.carwash.repository;

import java.util.List;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.carwash.model.Wash;
import com.carwash.model.WashStatus;

public interface WashRepository extends CrudRepository<Wash, String>, QuerydslPredicateExecutor<Wash> {

  List<Wash> findByClientId(String clientId);
  
  List<Wash> findByCarId(String carId);
  
  List<Wash> findByClientRegister(String clientRegister);
  
  List<Wash> findByStatus(WashStatus status);
  
  Wash getById(String id);
  
}