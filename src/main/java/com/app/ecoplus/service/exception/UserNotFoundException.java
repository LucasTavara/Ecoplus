package com.app.ecoplus.service.exception;

public class UserNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	// Metodo padrão de Exceção
    public UserNotFoundException(String message) {
        super(message);
    }
}
    