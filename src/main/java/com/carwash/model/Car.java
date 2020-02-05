package com.carwash.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity // it is assumed that this entity is mapped to a table named Car.
@Data
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String licensePlate;
	
	@Column
	private String model;
	
	@Column
	private String cardNumber;

}
