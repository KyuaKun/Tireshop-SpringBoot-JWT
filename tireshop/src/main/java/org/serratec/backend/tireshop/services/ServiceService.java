package org.serratec.backend.tireshop.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.serratec.backend.tireshop.dtos.ServiceDto;
import org.serratec.backend.tireshop.models.ServiceModel;
import org.serratec.backend.tireshop.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceService {

	@Autowired
	ServiceRepository serviceRepository;

	public ServiceModel convertServiceDtoToModel(ServiceDto serviceDto, ServiceModel serviceModel) {
		serviceModel.setDateService(serviceDto.getDateService());
		serviceModel.setProvService(serviceDto.getProvService());
		serviceModel.setValueService(serviceDto.getValueService());
		return serviceModel;
	}

	public ServiceDto convertServiceModelToDto(ServiceModel serviceModel, ServiceDto serviceDto) {
		serviceDto.setDateService(serviceModel.getDateService());
		serviceDto.setProvService(serviceModel.getProvService());
		serviceDto.setValueService(serviceModel.getValueService());
		return serviceDto;
	}

	@Transactional
	public void saveService(ServiceDto serviceDto) {
		ServiceModel service = new ServiceModel();
		convertServiceDtoToModel(serviceDto, service);
		service.setDateService(LocalDate.now());
		serviceRepository.save(service);
	}

	@Transactional
	public void saveServiceList(List<ServiceModel> listServiceModel) {
		serviceRepository.saveAll(listServiceModel);
	}

	public List<ServiceModel> findAllServices() {
		return serviceRepository.findAll();
	}

	public Optional<ServiceModel> findById(Integer idService) {
		return serviceRepository.findById(idService);
	}

	@Transactional
	public void updateService(Integer idService, ServiceDto serviceDto) {
		Optional<ServiceModel> serviceOptional = serviceRepository.findById(idService);

		if (serviceOptional.isPresent()) {
			ServiceModel service = new ServiceModel();

			if (serviceDto.getDateService() != null) {
				service.setDateService(serviceDto.getDateService());
			}
			if (serviceDto.getProvService() != null) {
				service.setProvService(serviceDto.getProvService());
			}
			if (serviceDto.getValueService() != null) {
				service.setValueService(serviceDto.getValueService());
			}
			serviceRepository.save(service);
		}
	}

	@Transactional
	public void deleteService(Integer idService) {
		serviceRepository.deleteById(idService);
	}

	@Transactional
	public void deleteAllServices() {
		serviceRepository.deleteAll();
	}
}
