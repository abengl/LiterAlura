package com.alessandragodoy.literalura.exception;

/**
 * Exception thrown when a resource is not found.
 */
public class RecursoNoEncontradoException extends RuntimeException {
	public RecursoNoEncontradoException(String message) {
		super(message);
	}
}