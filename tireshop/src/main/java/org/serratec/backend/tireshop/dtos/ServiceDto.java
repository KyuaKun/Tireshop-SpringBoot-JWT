package org.serratec.backend.tireshop.dtos;

import java.time.LocalDate;

public class ServiceDto {

	private Double valueService;
	private LocalDate dateService;
	private String provService;

	public ServiceDto(Double valueService) {
	}

	public ServiceDto() {
	}

	public ServiceDto(Double valueService, LocalDate dateService, String provService) {
		this.valueService = valueService;
		this.dateService = dateService;
		this.provService = provService;
	}

	public Double getValueService() {
		return valueService;
	}

	public void setValueService(Double valueService) {
		this.valueService = valueService;
	}

	public LocalDate getDateService() {
		return dateService;
	}

	public void setDateService(LocalDate dateService) {
		this.dateService = dateService;
	}

	public String getProvService() {
		return provService;
	}

	public void setProvService(String provService) {
		this.provService = provService;
	}
}
