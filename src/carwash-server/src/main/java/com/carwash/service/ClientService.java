package com.carwash.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carwash.model.Client;
import com.carwash.model.QClient;
import com.carwash.repository.ClientRepository;
import com.querydsl.core.BooleanBuilder;

//import lombok.extern.java.Log;

//@Log
@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	public Client save(Client client) {
//		log.info("class: ClientService, method: create");
		return clientRepository.save(client);
	}
	
	public List<Client> find(String term) {
		
		BooleanBuilder builder = new BooleanBuilder();
		QClient qc = QClient.client;
		
		builder.andAnyOf (
			qc.name.startsWithIgnoreCase(term),
			qc.phone.startsWith(term),
			qc.email.startsWithIgnoreCase(term));
		
		List<Client> result = new ArrayList<>();
		
		clientRepository.findAll(builder).forEach(result::add);
		
		return result;
	}
	
	public Client getClient(String id, String phone, String email) {
		
		if (id != null && phone == null && email == null) {
			return clientRepository.getById(id);
		}
		
		if (id == null && phone != null && email == null) {
			return clientRepository.getByPhone(phone);
		}

		if (id == null && phone == null && email != null) {
			return clientRepository.getByEmail(email);
		}
		
		return null;
	}
	
	
	public Client findById(String id) {
		return clientRepository.getById(id);
	}
	
	public Client getByPhone(String phone) {
		return clientRepository.getByPhone(phone);
	}
	
	public Client getByEmail(String email) {
		return clientRepository.getByEmail(email);
	}
	
}
