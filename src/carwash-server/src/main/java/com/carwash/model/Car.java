package com.carwash.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Car {

	@Id
	private String id;
	
	@Column
	private String model;
	
	@Column
	private String licensePlate;
	
	@Column
	private String cardNumber;

}
