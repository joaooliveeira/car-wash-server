package com.carwash.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "wash")
@Data
public class Wash {
	
	@Id
	@Column(name = "id")
	private String id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "client_id")
	private Client client;
	
	private String clientRegister;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "car_id")
	private Car car;
	
	private String kilometrage;
	
	private String washType;
	
	private Long value;
	
	@Enumerated(EnumType.STRING)
	private WashStatus status;
	
	private Date created;
	
	private String authorization;
	
}
