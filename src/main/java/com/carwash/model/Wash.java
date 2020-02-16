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
	private String id;
	
	@Column
	private String clientId;
	
	@Column
	private String clientRegister;
	
	@Column
	private String carId;
	
	@Column
	private String kilometrage;
	
	@Column
	private String washType;
	
	@Column
	private Long value;
	
	@Enumerated(EnumType.STRING)
	private WashStatus status;
	
	@Column
	private Date created;
	
	@Column
	private Date lastUpdate;
	
}
