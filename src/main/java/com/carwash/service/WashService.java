package com.carwash.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carwash.model.QWash;
import com.carwash.model.Wash;
import com.carwash.model.WashStatus;
import com.carwash.repository.WashRepository;
import com.querydsl.core.BooleanBuilder;

import lombok.extern.java.Log;

@Log
@Service
public class WashService {
	
	@Autowired
	private WashRepository washRepository;

	public Wash create(Wash wash) {
		
		wash.setLastUpdate(new Date());
		return washRepository.save(wash);
		
	}

	public List<Wash> filter(String carId, String clientId, String startDate, String endDate) throws ParseException {
		
		BooleanBuilder builder = new BooleanBuilder();
		QWash qw = QWash.wash;
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
		
		Date fromDate = formatter.parse(startDate);
		Date toDate = formatter.parse(endDate);
		
		System.out.println("fromDate : " + fromDate);
		System.out.println("toDate : " + toDate);
		
		if (carId != null) {
			builder.and(qw.carId.eq(carId));
		}
		
		if (clientId != null) {
			builder.and(qw.clientId.eq(clientId));
		}
		
		builder.and(qw.created.between(fromDate, toDate));
		
		
		List<Wash> result = new ArrayList<>();
		
		washRepository.findAll(builder).forEach(result::add);
		
		return result;
		
	}

	public List<Wash> getRunningWashes() {
		return washRepository.findByStatus(WashStatus.RUNNING);
	}
	
//	public List<Wash> find(String term) {
//		
//		BooleanBuilder builder = new BooleanBuilder();
//		QWash qw = QWash.wash;
//		
//		builder.andAnyOf(qw.)
//		
//		
//		builder.and(qw.created.between(filter.getFromDate(), filter.getToDate()));
//		
//		List<Wash> result = new ArrayList<>();
//		
//		washRepository.findAll(builder).forEach(result::add);
//		
//		return result;
//	}

}
