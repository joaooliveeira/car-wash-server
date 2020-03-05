package com.carwash.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WashFilter {

	private String carId;
	
	private String clientId;
	
	private String fromDate;
	
	private String toDate;
	
	public Date getFromDate() throws ParseException {
		return formatStringToDate(this.fromDate);
	}
	
	public Date getToDate() throws ParseException {
		return formatStringToDate(this.toDate);
	}
	
	private Date formatStringToDate(String date) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.parse(date);
	}
}
