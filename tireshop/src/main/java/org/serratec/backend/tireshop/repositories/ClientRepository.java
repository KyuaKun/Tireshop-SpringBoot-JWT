package org.serratec.backend.tireshop.repositories;

import java.util.Optional;

import org.serratec.backend.tireshop.models.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, Integer> {

	Optional<ClientModel> findByEmail(String email);

	Optional<ClientModel> findByCpf(String cpf);

}
