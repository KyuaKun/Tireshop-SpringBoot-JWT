package org.serratec.backend.tireshop.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "CARS")
public class CarModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "car_cd_id")
	private Long idCar;
	@Column(name = "car_tx_model_car", nullable = false)
	@NotBlank
	private String modelCar;
	@Column(name = "car_tx_brand_car", nullable = false)
	@NotBlank
	private String brandCar;
	@Column(name = "car_nu_year_car", nullable = true)
	@NotBlank
	private Integer yearCar;
	@Column(name = "car_nu_plate_car", nullable = false)
	@NotBlank
	private String plateCar;

	@ManyToOne
	@JoinColumn(name = "cd_id_client", referencedColumnName = "client_cd_id")
	@NotBlank
	private ClientModel client;

	@OneToMany(mappedBy = "carModel")
	private List<ServiceModel> listServices;

	public CarModel() {
		super();
	}

	public CarModel(Long idCar, String modelCar, String brandCar, Integer yearCar, String plateCar,
			ClientModel client) {
		super();
		this.idCar = idCar;
		this.modelCar = modelCar;
		this.brandCar = brandCar;
		this.yearCar = yearCar;
		this.plateCar = plateCar;
		this.client = client;
	}

	public Long getIdCar() {
		return idCar;
	}

	public void setIdCar(Long idCar) {
		this.idCar = idCar;
	}

	public String getModelCar() {
		return modelCar;
	}

	public void setModelCar(String modelCar) {
		this.modelCar = modelCar;
	}

	public String getBrandCar() {
		return brandCar;
	}

	public void setBrandCar(String brandCar) {
		this.brandCar = brandCar;
	}

	public Integer getYearCar() {
		return yearCar;
	}

	public void setYearCar(Integer yearCar) {
		this.yearCar = yearCar;
	}

	public String getPlateCar() {
		return plateCar;
	}

	public void setPlateCar(String plateCar) {
		this.plateCar = plateCar;
	}

	public ClientModel getClient() {
		return client;
	}

	public void setClient(ClientModel client) {
		this.client = client;
	}

}
