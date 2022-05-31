package org.serratec.backend.tireshop.dtos;

import org.serratec.backend.tireshop.models.ClientModel;

public class CarDto {

	private String modelCar;

	private String brandCar;

	private Integer yearCar;

	private ClientModel client;

	private String plateCar;

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

	public ClientModel getClient() {
		return client;
	}

	public void setClient(ClientModel client) {
		this.client = client;
	}

	public String getPlateCar() {
		return plateCar;
	}

	public void setPlateCar(String plateCar) {
		this.plateCar = plateCar;
	}

}
