package com.carwash.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carwash.model.Wash;
import com.carwash.repository.WashRepository;

@Service
public class WashService {
	
	@Autowired
	private WashRepository washRepository;

	public Wash create(Wash wash) {
		return washRepository.save(wash);
	}

}
