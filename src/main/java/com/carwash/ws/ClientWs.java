package com.carwash.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.carwash.exception.CarWashException;
import com.carwash.model.Client;
import com.carwash.service.ClientService;

@RestController
@RequestMapping(value = "client")
public class ClientWs {
	
	@Autowired
	private ClientService clientService;
	
	@RequestMapping(value = "create", method = RequestMethod.PUT)
	public Client create(@RequestBody Client client) {
		return clientService.create(client);
	}
	
	@RequestMapping(value = "find/{term}", method = RequestMethod.GET)
	public List<Client> findClient(@PathVariable("term") String term) {
		return clientService.findClient(term);
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") String id) throws CarWashException {
		clientService.delete(id);
	}
	
}
