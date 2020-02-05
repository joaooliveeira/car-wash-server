package com.carwash.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.carwash.model.Wash;
import com.carwash.service.WashService;

@RestController
@RequestMapping(value="wash")
public class WashWs {

	@Autowired
	private WashService washService;
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public Wash create(@RequestBody Wash wash) {
		return washService.create(wash);
	}
	
}
