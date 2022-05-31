package org.serratec.backend.tireshop.repositories;

import org.serratec.backend.tireshop.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer>{

}
