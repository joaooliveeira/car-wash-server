package com.carwash.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Wash {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Long carId;
	
	@Column
	private Long clientId;
	
	@Column
	private String clientRegister;
	
	@Column
	private String washType;
	
	@Column
	private Long value;
//	private Date created;
	
}
