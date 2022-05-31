package org.serratec.backend.tireshop.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "CLIENTS")
public class ClientModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "client_cd_id")
	private Integer id;
	@Column(name = "client_tx_name", nullable = false)
	@NotBlank
	private String name;
	@Column(name = "client_nu_cpf", nullable = false, unique = true)
	@NotBlank
	private String cpf;
	@Column(name = "client_nu_tell", nullable = false)
	@NotBlank
	private String numTell;
	@Column(name = "client_tx_email", nullable = false)
	@NotBlank
	private String email;

	@OneToMany(mappedBy = "client")
	private List<CarModel> listCars;

	public ClientModel() {
	}

	public ClientModel(Integer id, String name, String cpf, String numTell, String email) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.numTell = numTell;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNumTell() {
		return numTell;
	}

	public void setNumTell(String numTell) {
		this.numTell = numTell;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
