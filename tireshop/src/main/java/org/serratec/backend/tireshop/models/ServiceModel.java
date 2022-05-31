package org.serratec.backend.tireshop.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "SERVICES")
public class ServiceModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "service_cd_idService")
	private Integer idService;

	@Column(name = "service_nu_value", nullable = false)
	@NotBlank
	private Double valueService;

	@Column(name = "service_dt_service", nullable = false)
	@NotBlank
	private LocalDate dateService;

	@Column(name = "service_tx_provided_service", nullable = false)
	@NotBlank
	private String provService;

	@ManyToOne
	@JoinColumn(name = "cd_idCar", referencedColumnName = "car_cd_id")
	private CarModel carModel;

	public ServiceModel() {
	}

	public ServiceModel(Integer idService, Double valueService, LocalDate dateService, String provService) {
		this.idService = idService;
		this.valueService = valueService;
		this.dateService = dateService;
		this.provService = provService;
	}

	public Integer getIdService() {
		return idService;
	}

	public void setIdService(Integer idService) {
		this.idService = idService;
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
