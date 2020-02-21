package com.carwash.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carwash.model.QWash;
import com.carwash.model.Wash;
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
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		
		calendar.setTime(formatter.parse(endDate));
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		
		Date fromDate = formatter.parse(startDate);
		Date toDate = calendar.getTime();
		
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
	
//	public List<Wash> find(WashFilter filter) throws ParseException {
//		
//		BooleanBuilder builder = new BooleanBuilder();
//		QWash qw = QWash.wash;
//		
//		System.out.println("fromDate: " + filter.getFromDate());
//		System.out.println("toDate : " + filter.getToDate());
//		System.out.println("carId: " + filter.getCarId());
//		
//		if (filter.getCarId() != null) {
//			builder.and(qw.carId.eq(filter.getCarId()));
//		}
//		
//		if (filter.getClientId() != null) {
//			builder.and(qw.clientId.eq(filter.getClientId()));
//		}
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
