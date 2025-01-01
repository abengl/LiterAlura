package com.alessandragodoy.literalura.exception;

/**
 * Exception thrown when there is an error consuming an API.
 */
public class ConsumoAPIException extends RuntimeException {
	public ConsumoAPIException(String message) {
		super(message);
	}
}
