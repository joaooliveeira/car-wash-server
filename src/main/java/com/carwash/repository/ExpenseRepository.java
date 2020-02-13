package com.carwash.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carwash.model.Expense;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Long> {

}