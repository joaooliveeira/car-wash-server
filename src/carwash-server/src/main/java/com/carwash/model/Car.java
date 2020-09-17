package com.carwash.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "car")
@Data
public class Car {

	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "model")
	private String model;
	
	@Column(name = "license_plate")
	private String licensePlate;
	
	@Column(name = "card_number")
	private String cardNumber;
	
	@Column(name = "last_driver_register")
	private String lastDriverRegister;

}
