package com.carwash.repository;

import java.util.List;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.carwash.model.Wash;

public interface WashRepository extends CrudRepository<Wash, String>, QuerydslPredicateExecutor<Wash> {

  List<Wash> findByClientId(String clientId);
  List<Wash> findByCarId(String carId);
  List<Wash> findByClientRegister(String clientRegister);
  Wash getById(String id);
  
}