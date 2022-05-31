package org.serratec.backend.tireshop.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.serratec.backend.tireshop.dtos.ClientDto;
import org.serratec.backend.tireshop.models.ClientModel;
import org.serratec.backend.tireshop.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

	@Autowired
	ClientRepository clientRepository;

	public ClientModel convertClientDtoToModel(ClientDto clientDto, ClientModel clientModel) {
		clientModel.setName(clientDto.getName());
		clientModel.setCpf(clientDto.getCpf());
		clientModel.setNumTell(clientDto.getNumTell());
		clientModel.setEmail(clientDto.getEmail());
		return clientModel;
	}

	public ClientDto convertClientModelToDto(ClientModel clientModel, ClientDto clientDto) {
		clientDto.setCpf(clientModel.getCpf());
		clientDto.setEmail(clientModel.getEmail());
		clientDto.setName(clientModel.getName());
		clientDto.setNumTell(clientModel.getNumTell());
		return clientDto;
	}

	@Transactional
	public void saveClient(ClientDto clientDto) {
		ClientModel client = new ClientModel();
		convertClientDtoToModel(clientDto, client);
		clientRepository.save(client);
	}

	@Transactional
	public void saveClientList(List<ClientModel> listClient) {
		clientRepository.saveAll(listClient);
	}

	public List<ClientModel> findAllClients() {
		return clientRepository.findAll();
	}

	public Optional<ClientModel> findById(Integer idClient) {
		return clientRepository.findById(idClient);
	}

	public Optional<ClientModel> findByCpf(String cpf) {
		return clientRepository.findByCpf(cpf);
	}

	public Optional<ClientModel> findByEmail(String email) {
		return clientRepository.findByEmail(email);
	}

	@Transactional
	public void updateClient(Integer idClient, ClientDto clientDto) {
		Optional<ClientModel> clientOptional = clientRepository.findById(idClient);

		if (clientOptional.isPresent()) {
			ClientModel client = new ClientModel();

			if (clientDto.getCpf() != null) {
				client.setCpf(clientDto.getCpf());
			}

			if (clientDto.getEmail() != null) {
				client.setEmail(clientDto.getEmail());
			}

			if (clientDto.getName() != null) {
				client.setName(clientDto.getName());
			}

			if (clientDto.getNumTell() != null) {
				client.setNumTell(clientDto.getNumTell());
			}

			clientRepository.save(client);
		}

	}

	@Transactional
	public void deleteClient(Integer idClient) {
		clientRepository.deleteById(idClient);
	}

	@Transactional
	public void deleteAllClients() {
		clientRepository.deleteAll();
	}
}
