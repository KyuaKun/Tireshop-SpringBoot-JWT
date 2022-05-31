package org.serratec.backend.tireshop.dtos;


public class ClientDto {

	private String name;

	private String cpf;

	private String numTell;

	private String email;

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
