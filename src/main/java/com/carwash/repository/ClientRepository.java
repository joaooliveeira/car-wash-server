package com.carwash.repository;

import java.util.List;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.carwash.model.Client;

public interface ClientRepository extends CrudRepository<Client, String>, QuerydslPredicateExecutor<Client> {

  List<Client> findByName(String name);
  List<Client> findByPhone(String phone);
  List<Client> findByEmail(String email);
  
}