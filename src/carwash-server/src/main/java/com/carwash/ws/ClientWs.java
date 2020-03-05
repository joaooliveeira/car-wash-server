package com.carwash.ws;

import java.text.ParseException;
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
	
	@RequestMapping(value = "save", method = RequestMethod.PUT)
	public Client saveClient(@RequestBody Client client) {
		return clientService.save(client);
	}
	
	@RequestMapping(value = "find/{term}", method = RequestMethod.GET)
	public List<Client> findClient(@PathVariable("term") String term) {
		return clientService.find(term);
	}

	@RequestMapping(value="sync/{date}", method = RequestMethod.GET)
	public List<Client> syncClient(@PathVariable("date") String lastSyncDate) throws ParseException {
		return clientService.sync(lastSyncDate);
	}
	
}
