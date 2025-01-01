package com.alessandragodoy.literalura.service;

import com.alessandragodoy.literalura.exception.ConsumoAPIException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Service class for converting JSON data to Java objects.
 */
public class ConvierteDatos implements IConvierteDatos {
	private final ObjectMapper mapper = new ObjectMapper();

	@Override
	public <T> T convertirDatos(String json, Class<T> clase) {
		try {
			return mapper.readValue(json, clase);
		} catch (JsonProcessingException e) {
			throw new ConsumoAPIException(e.getMessage());
		}
	}
}
