package com.carwash.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carwash.exception.CarWashException;
import com.carwash.model.Client;
import com.carwash.model.ClietStatus;
import com.carwash.model.QClient;
import com.carwash.repository.ClientRepository;
import com.querydsl.core.BooleanBuilder;

import lombok.extern.java.Log;

@Log
@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	public Client create(Client client) {
		// log.info("class: ClientService, method: create");
		return clientRepository.save(client);
	}
	
	public List<Client> findClient(String term) {
		BooleanBuilder builder = new BooleanBuilder();
		QClient qc = QClient.client;
		
		builder.andAnyOf (
			qc.name.startsWithIgnoreCase(term),
			qc.phone.startsWith(term),
			qc.email.startsWithIgnoreCase(term));
		
		builder.and(qc.status.eq(ClietStatus.ACTIVE));
		
		List<Client> result = new ArrayList<>();
		
		clientRepository.findAll(builder).forEach(result::add);
		
		return result;
	}

	public Client update(String id, Client client) throws CarWashException {
		
		Client fromDb = clientRepository.findById(id).orElse(null);
		if (fromDb == null) {
			throw new CarWashException("Cliente não encontrado");
		}
		
		fromDb.setName(client.getName());
		fromDb.setPhone(client.getPhone());
		fromDb.setEmail(client.getEmail());
		
		return clientRepository.save(fromDb);
	}
	
	public void delete(String id) throws CarWashException {
		
		Client fromDb = clientRepository.findById(id).orElse(null);
		if (fromDb == null) {
			throw new CarWashException("Cliente não encontrado");
		}
		
		fromDb.setStatus(ClietStatus.DELETED);
		
		clientRepository.save(fromDb);
	}
}
