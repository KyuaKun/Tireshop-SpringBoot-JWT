package org.serratec.backend.tireshop.controllers;

import java.util.List;

import javax.validation.Valid;

import org.serratec.backend.tireshop.dtos.CarDto;
import org.serratec.backend.tireshop.models.CarModel;
import org.serratec.backend.tireshop.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tireshop-car")
public class CarController {

	@Autowired
	CarService carService;

	@PostMapping
	public ResponseEntity<Void> saveCar(@Valid @RequestBody CarDto carDto) {
		carService.saveCar(carDto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PostMapping("/save-car-list")
	public ResponseEntity<Void> saveCarList(@Valid @RequestBody List<CarModel> listCar) {
		carService.saveCarList(listCar);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
