package com.carwash.repository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.carwash.model.Client;

public interface ClientRepository extends CrudRepository<Client, String>, QuerydslPredicateExecutor<Client> {

	Client getById(String id);

	Client getByPhone(String phone);
	
	Client getByEmail(String email);
	
	
}