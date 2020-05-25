package com.carwash.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carwash.model.Client;
import com.carwash.service.ClientService;

@RestController
@RequestMapping(value = "client")
public class ClientWs {
	
	@Autowired
	private ClientService clientService;
	
	@RequestMapping(value = "save", method = RequestMethod.PUT)
	public Client saveClient(@RequestBody Client client) {
		return clientService.save(client);
	}
	
	@RequestMapping(value = "find/{term}", method = RequestMethod.GET)
	public List<Client> findClient(@PathVariable("term") String term) {
		return clientService.find(term);
	}
	
	@RequestMapping(value = "get/", method = RequestMethod.GET)
	public Client getClient(
			@RequestParam(name = "id", required = false) String id,
			@RequestParam(name = "phone", required = false) String phone,
			@RequestParam(name = "email", required = false) String email) {
		return clientService.getClient(id, phone, email);
	}
	
}
