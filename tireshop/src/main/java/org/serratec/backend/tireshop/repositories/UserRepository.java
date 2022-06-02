package org.serratec.backend.tireshop.repositories;

import java.util.Optional;

import org.serratec.backend.tireshop.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {
	
	@Query(value = "FROM UserModel u WHERE u.login = ?1")
	Optional<UserModel> findByLogin(String login);
}
