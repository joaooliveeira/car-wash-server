package com.carwash.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carwash.model.Client;
import com.carwash.model.QClient;
import com.carwash.repository.ClientRepository;
import com.querydsl.core.BooleanBuilder;

import lombok.extern.java.Log;

@Log
@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	public Client save(Client client) {
		log.info("class: ClientService, method: create");
		
		client.setLastUpdate(new Date());
		
		return clientRepository.save(client);
	}
	
	public Client findById(String id) {
		return clientRepository.findById(id).orElse(null);
	}
	
	public List<Client> find(String term) {
		
		BooleanBuilder builder = new BooleanBuilder();
		QClient qc = QClient.client;
		
		builder.andAnyOf (
			qc.name.startsWithIgnoreCase(term),
			qc.phone.startsWith(term),
			qc.email.startsWith(term));
		
		List<Client> result = new ArrayList<>();
		
		clientRepository.findAll(builder).forEach(result::add);
		
		return result;
	}
	
	public List<Client> sync(String lastSyncDate) throws ParseException {
		
		BooleanBuilder builder = new BooleanBuilder();
		QClient qc = QClient.client;
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
		Date fromDate = formatter.parse(lastSyncDate);
		
		builder.and(qc.lastUpdate.after(fromDate));
		
		List<Client> result = new ArrayList<Client>();
		
		clientRepository.findAll(builder).forEach(result::add);
		
		return result;
		
	}
}