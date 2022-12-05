package com.example.demo.Controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.Client;
import com.example.demo.services.ClientService;

@RestController
public class clientController {
	
	private ClientService clientService;
	
	@Autowired
	public clientController(ClientService clientService) {
		this.clientService = clientService;
	}

	@GetMapping("/client")
	public ResponseEntity getClients() {
		return clientService.getClients();
	}
	@GetMapping("/client/{id}")
	public Optional<Client> getClientById(@PathVariable int id) {
		return clientService.getClientById(id);
	}
	@PostMapping("/client") 
	public void addClient(@RequestBody Client client) {
		clientService.addClient(client);
	}
	@PutMapping("/client/{id}") 
	public void updateClient(@Valid @RequestBody Client client, @PathVariable int id) {
		clientService.updateClient(client, id);
	}
	@DeleteMapping("/client/{id}") 
	public void deleteClient(@PathVariable int id) {
		clientService.deleteClient(id);
	}
}
