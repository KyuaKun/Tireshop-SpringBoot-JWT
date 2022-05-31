package org.serratec.backend.tireshop.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.serratec.backend.tireshop.dtos.ClientDto;
import org.serratec.backend.tireshop.models.ClientModel;
import org.serratec.backend.tireshop.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/tireshop-client")
public class ClientController {

	@Autowired
	ClientService clientService;

	@PostMapping
	public ResponseEntity<Void> saveClient(@RequestBody @Valid ClientDto clientDto) {
		clientService.saveClient(clientDto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PostMapping("/save-list-clients")
	public ResponseEntity<Void> saveClientList(@RequestBody @Valid List<ClientModel> listClient) {
		clientService.saveClientList(listClient);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<ClientModel>> findAllClients() {
		return ResponseEntity.status(HttpStatus.OK).body(clientService.findAllClients());
	}

	@GetMapping("/{idClient}")
	public ResponseEntity<Object> findIdClient(@Valid @PathVariable Integer idClient) {
		Optional<ClientModel> clientOptional = clientService.findById(idClient);
		if (clientOptional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CLIENTE NÃO ENCONTRADO.");
		}

		return ResponseEntity.status(HttpStatus.OK).body(clientOptional.get());
	}

	@PutMapping("/{idClient}")
	public ResponseEntity<Void> updateClient(@Valid @PathVariable Integer idClient, @RequestBody ClientDto clientDto) {
		clientService.updateClient(idClient, clientDto);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{idClient}")
	public ResponseEntity<Object> deleteClient(@Valid @PathVariable Integer idClient) {
		Optional<ClientModel> clientOptional = clientService.findById(idClient);
		if (clientOptional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CLIENTE NÃO ENCONTRADO.");
		}

		clientService.deleteClient(idClient);
		return ResponseEntity.status(HttpStatus.OK).body("CLIENTE DELETADO");
	}
}
