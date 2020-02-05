package com.carwash.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.carwash.model.Wash;

public interface WashRepository extends CrudRepository<Wash, Long> {

  List<Wash> findByClientId(Long clientId);
  List<Wash> findByCarId(Long carId);
  List<Wash> findByClientRegister(String clientRegister);
  
}