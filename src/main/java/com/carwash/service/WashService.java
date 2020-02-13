package com.carwash.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carwash.model.Wash;
import com.carwash.model.WashStatus;
import com.carwash.repository.WashRepository;

@Service
public class WashService {
	
	@Autowired
	private WashRepository washRepository;

	public Wash create(Wash wash) {
		
		wash.setStatus(WashStatus.RUNNING);
		wash.setCreated(new Date());
		return washRepository.save(wash);
		
	}

}