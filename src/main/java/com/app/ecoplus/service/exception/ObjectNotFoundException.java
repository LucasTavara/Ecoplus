package com.app.ecoplus.service.exception;


public class ObjectNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	// Metodo padrão de Exceção
    public ObjectNotFoundException(String message) {
        super(message);
    }

}