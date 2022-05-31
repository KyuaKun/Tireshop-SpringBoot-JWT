package org.serratec.backend.tireshop.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.serratec.backend.tireshop.dtos.ServiceDto;
import org.serratec.backend.tireshop.models.ServiceModel;
import org.serratec.backend.tireshop.services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tireshop-service")
public class ServiceController {

	@Autowired
	ServiceService serviceService;

	@PostMapping
	public ResponseEntity<Void> saveService(@RequestBody @Valid ServiceDto serviceDto) {
		serviceService.saveService(serviceDto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PostMapping("/save-list-services")
	public ResponseEntity<Void> saveServiceList(@RequestBody @Valid List<ServiceModel> listService) {
		serviceService.saveServiceList(listService);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<ServiceModel>> findAllServices() {
		return ResponseEntity.status(HttpStatus.OK).body(serviceService.findAllServices());
	}

	@GetMapping("/{idService}")
	public ResponseEntity<Object> findService(@PathVariable @Valid Integer idService) {
		Optional<ServiceModel> serviceOptional = serviceService.findById(idService);
		if (serviceOptional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("SERVICE NOT FOUND.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(serviceOptional.get());
	}

	@PutMapping("/idService")
	public ResponseEntity<Void> updateService(@Valid @PathVariable Integer idService, ServiceDto serviceDto) {
		serviceService.updateService(idService, serviceDto);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

}
