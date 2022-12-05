package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Models.Client;
import com.example.demo.Repositories.clientRepository;

@Service
public class ClientService {
	private clientRepository ClientRepository;
	
	@Autowired
	public ClientService(clientRepository ClientRepository) {
		this.ClientRepository = ClientRepository;
	}
	
	public ResponseEntity getClients() {
		try {
			List<Client> clients = ClientRepository.findAll();
			return new ResponseEntity(clients, HttpStatus.OK);
			
		}catch(Exception e) {
			return new ResponseEntity("Internal server error", HttpStatus.OK);
		}
	}

	public void addClient(Client client) {
		
		ClientRepository.save(client);
	}

	public Optional<Client> getClientById(int id) {
		Optional<Client> client = ClientRepository.findById(id);
		
		if(client.isEmpty())
			throw new IllegalStateException("El id no existe");
		return client;
	}

	public void updateClient(Client client, int id) {
		Optional<Client> clientInDB = ClientRepository.findById(id);
		clientInDB.get().setName(client.getName());
		clientInDB.get().setLastname(client.getLastname());
		
		ClientRepository.save(clientInDB.get());
	}

	public void deleteClient(int id) {
		ClientRepository.deleteById(id);		
	}
	
}
