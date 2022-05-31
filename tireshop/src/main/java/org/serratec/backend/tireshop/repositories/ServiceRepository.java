package org.serratec.backend.tireshop.repositories;

import org.serratec.backend.tireshop.models.ServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceModel, Integer> {

}
