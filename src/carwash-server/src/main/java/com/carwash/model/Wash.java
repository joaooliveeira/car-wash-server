package com.carwash.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Wash {
	
	@Id
	private String id;
	
	private String clientId;
	
	private String clientRegister;
	
	private String carId;
	
	private String kilometrage;
	
	private String washType;
	
	private Long value;
	
	private String authorization;
	
	@Enumerated(EnumType.STRING)
	private WashStatus status;
	
	private Date created;
	
	private Date lastUpdate;
	
}
