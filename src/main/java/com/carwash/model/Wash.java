package com.carwash.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	private String kilometrage;
	
	@Column
	private Long clientId;
	
	@Column
	private Long clientRegister;
	
	@Column
	private String washType;
	
	@Column
	private Long value;
	
	@Enumerated(EnumType.STRING)
	private WashStatus status;
	
	@Column
	private Date created;
	
}
