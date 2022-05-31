package org.serratec.backend.tireshop.exception;

@SuppressWarnings("serial")
public class ClientException extends Exception {

	public ClientException() {
		super();
	}

	public ClientException(String message) {
		super(message);
	}

	public ClientException(String message, Exception cause) {
		super(message, cause);
	}

	public ClientException(Exception e) {
		super(e);
	}

}
