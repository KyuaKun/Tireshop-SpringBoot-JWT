package org.serratec.backend.tireshop.securities;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserAuthenticationResponse implements Serializable {

	private final String token;

	public UserAuthenticationResponse(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

}
