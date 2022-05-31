package org.serratec.backend.tireshop.services;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.tireshop.dtos.CarDto;
import org.serratec.backend.tireshop.models.CarModel;
import org.serratec.backend.tireshop.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CarService {

	@Autowired
	CarRepository carRepository;

	public CarModel convertCarDtoToModel(CarDto carDto, CarModel carModel) {
		carModel.setBrandCar(carDto.getBrandCar());
		carModel.setClient(carDto.getClient());
		carModel.setModelCar(carDto.getModelCar());
		carModel.setYearCar(carDto.getYearCar());
		carModel.setPlateCar(carDto.getPlateCar());
		return carModel;
	}

	public CarDto convertCarModelToDto(CarModel carModel, CarDto carDto) {
		carDto.setBrandCar(carModel.getBrandCar());
		carDto.setClient(carModel.getClient());
		carDto.setModelCar(carModel.getModelCar());
		carDto.setYearCar(carModel.getYearCar());
		carDto.setPlateCar(carModel.getPlateCar());
		return carDto;
	}

	@Transactional
	public void saveCar(CarDto carDto) {
		CarModel carModel = new CarModel();
		convertCarDtoToModel(carDto, carModel);
		carRepository.save(carModel);
	}

	@Transactional
	public void saveCarList(List<CarModel> carModel) {
		carRepository.saveAll(carModel);
	}

	public List<CarModel> findAllCars() {
		return carRepository.findAll();
	}

	public Optional<CarModel> findById(Long idCar) {
		return carRepository.findById(idCar);
	}

	public Optional<CarModel> findByPlateCar(String plateCar) {
		return carRepository.findByPlateCar(plateCar);
	}

	@Transactional
	public void updateCar(Long idCar, CarDto carDto) {
		Optional<CarModel> carOptional = carRepository.findById(idCar);
		if (carOptional.isPresent()) {
			CarModel car = new CarModel();
			if (carDto.getBrandCar() != null) {
				car.setBrandCar(carDto.getBrandCar());
			}

			if (carDto.getModelCar() != null) {
				car.setModelCar(carDto.getModelCar());
			}
			if (carDto.getPlateCar() != null) {
				car.setPlateCar(carDto.getPlateCar());
			}

			if (carDto.getYearCar() != null) {
				car.setYearCar(carDto.getYearCar());
			}

			carRepository.save(car);
		}

	}

	@Transactional
	public void deleteCarById(Long idcar) {
		carRepository.deleteById(idcar);
	}

	@Transactional
	public void deleteAllCars() {
		carRepository.deleteAll();
	}
}
