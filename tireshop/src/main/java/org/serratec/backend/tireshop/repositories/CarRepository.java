package org.serratec.backend.tireshop.repositories;

import java.util.Optional;

import org.serratec.backend.tireshop.models.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<CarModel, Long> {

	Optional<CarModel> findByPlateCar(String plateCar);

}
